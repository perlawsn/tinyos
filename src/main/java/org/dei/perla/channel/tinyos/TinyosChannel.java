package org.dei.perla.channel.tinyos;

import org.dei.perla.core.channel.AbstractChannel;
import org.dei.perla.core.channel.ByteArrayPayload;
import org.dei.perla.core.channel.ChannelException;
import org.dei.perla.core.channel.IORequest;
import org.dei.perla.core.channel.Payload;

public class TinyosChannel extends AbstractChannel {

	private final int moteId;
	private final TinyosServerListener tosl;

	public TinyosChannel(int id, TinyosServerListener tosl) {
		super("TinyOS Channel " + id);
		this.moteId = id;
		this.tosl = tosl;
	}

	public int getMoteId() {
		return moteId;
	}

	public void notifyTosAsyncData(Payload result) {
		ByteArrayPayload res = (ByteArrayPayload) result;
		notifyAsyncData(res);

	}

	@Override
	public Payload handleRequest(IORequest r) throws ChannelException,
			InterruptedException {
		if (!(r instanceof TinyosIORequest)) {
			throw new ChannelException(
					"Wrong IORequest received, TinyosIORequest expected");
		}
		tosl.send((TinyosIORequest) r, moteId);
		return null;
	}

}
