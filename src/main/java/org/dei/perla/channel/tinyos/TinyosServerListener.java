package org.dei.perla.channel.tinyos;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.dei.perla.core.channel.ByteArrayPayload;
import org.dei.perla.core.channel.ChannelException;
import org.dei.perla.core.channel.IOHandler;

import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;
import net.tinyos.message.MoteIF;

public class TinyosServerListener implements MessageListener {

	private final MoteIF moteIF;
	private final HashMap<Integer, NewPackage> payMap = new HashMap<Integer, NewPackage>();
	private final Map<Integer, TinyosChannel> moteMap = new ConcurrentHashMap<>();
	private IOHandler handler;

	public TinyosServerListener(MoteIF moteIF) {
		this.moteIF = moteIF;
		this.moteIF.registerListener(new TinyosSerialMsg(28), this);
	}

	protected void addChannel(TinyosChannel c) {
		moteMap.put(c.getMoteId(), c);
	}

	@Override
	public void messageReceived(int to, Message message) {
		ByteArrayPayload result = null;
		TinyosSerialMsg msg = (TinyosSerialMsg) message;

		short[] temp = msg.get_pPayload_data();

		// controllare se ci sono valori negativi
		byte[] byteArray = UsefulMethods.ShortToByte_ByteBuffer_Method(temp);
		System.out.println("Il pacchetto " + msg.get_pHeader_id()
				+ " è composto da  " + msg.get_pHeader_numPcktToSend());
		NewPackage aPack = payMap.get(msg.get_pHeader_id());
		if (msg.get_pHeader_numPcktToSend() > 1) {

			if (aPack == null) {

				aPack = new NewPackage(msg);

				payMap.put(msg.get_pHeader_id(), aPack);
			}
			aPack.addPayload(byteArray, msg.get_pHeader_numPckt());

			if (!aPack.getCompleted()) {
				return;
			}

			result = new ByteArrayPayload(buildPayload(aPack.getPayload(),
					aPack.getNumSegments(), aPack.getTotalPayloadSize()));

		} else if (msg.get_pHeader_type() != 0) {

			byte[] bytepyld = UsefulMethods.ShortToByte_ByteBuffer_Method(msg
					.get_pPayload_data());
			result = new ByteArrayPayload(bytepyld);

		}

		if (msg.get_pHeader_type() != 0) {

			TinyosChannel ch = moteMap.get(msg.get_pHeader_id());
			if (ch != null) {
				ch.notifyTosAsyncData(result);
			}
		} else {
			if (handler != null) {
				handler.complete(null, Optional.of(result));
			}
		}

	}

	public void send(TinyosIORequest req, int moteId) throws ChannelException {
		NewPackage pack = new NewPackage(req, moteId);
		for (int i = 0; i < pack.getNumSegments(); i++) {
			TinyosSerialMsg msg;
			msg = new TinyosSerialMsg();
			msg.set_pHeader_id(pack.getId());
			msg.set_pHeader_numPckt(i);
			msg.set_pHeader_numPcktToSend(pack.getNumSegments());
			msg.set_pHeader_type(pack.getType());
			msg.set_pPayload_data(UsefulMethods.ByteToShorts(pack
					.getSegmentPayload(i)));
			try {
				moteIF.send(pack.getId(), msg);
			} catch (IOException e) {
				throw new ChannelException(
						"Error while sending message to tinyos", e);
			}
		}
	}

	public byte[] buildPayload(byte[][] payload, int numSegm, int totalSize) {
		byte[] totPld = new byte[totalSize];
		int index = 0;
		for (int i = 0; i < numSegm; i++) {
			for (int j = 0; j < payload[i].length; j++) {
				totPld[index] = payload[i][j];

				index++;
			}
		}

		return totPld;
	}

	private class NewPackage {
		private int id;
		private int type;
		private int numSegments;
		private boolean completed = false;
		private byte[][] payload;
		private int totalPayloadSize = 0;

		public NewPackage(TinyosSerialMsg msg) {
			id = msg.get_pHeader_id();
			numSegments = msg.get_pHeader_numPcktToSend();
			type = msg.get_pHeader_type();
			this.payload = new byte[numSegments][];
		}

		public NewPackage(TinyosIORequest req, int moteId) {
			id = moteId;
			type = 7; // Da modificare in base ai cambiamenti che faremo con il
						// tinyos
			ByteBuffer reqPayload = req.getData().asByteBuffer();
			totalPayloadSize = reqPayload.array().length;
			int num = (int) Math.ceil(((double) totalPayloadSize)
					/ (double) TinyosSerialMsg.DEFAULT_MESSAGE_SIZE);
			numSegments = num;
			payload = new byte[num][];
			int i = 0;
			do {
				byte[] part = new byte[TinyosSerialMsg.DEFAULT_MESSAGE_SIZE];
				reqPayload.get(part);
				payload[i] = part;
				i++;

			} while (reqPayload.remaining() > 0);
			completed = true;

		}

		public int getId() {
			return id;
		}

		public int getType() {
			return type;
		}

		public int getNumSegments() {
			return numSegments;
		}

		public void addPayload(byte[] segment, int i) {

			this.payload[i] = new byte[segment.length];
			payload[i] = segment;
			this.totalPayloadSize += payload[i].length;
			if (this.getArrivedSegments() == this.numSegments) {
				System.out.println("Completato il pacchetto " + this.id);
				completed = true;
			}

		}

		public byte[][] getPayload() {
			return this.payload;
		}

		public byte[] getSegmentPayload(int i) {
			byte[] segment = payload[i];
			return segment;
		}

		public int getArrivedSegments() {
			int num = 0;
			for (int i = 0; i < this.getNumSegments(); i++) {
				if (payload[i] != null) {
					num++;
				}
			}

			return num;
		}

		public boolean getCompleted() {
			return this.completed;
		}

		public int getTotalPayloadSize() {
			return this.totalPayloadSize;
		}
	}

	public void addDescriptorHandler(IOHandler handler) {

		this.handler = handler;

	}

}
