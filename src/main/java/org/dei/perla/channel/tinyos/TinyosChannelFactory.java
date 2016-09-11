package org.dei.perla.channel.tinyos;

import net.tinyos.message.MoteIF;
import net.tinyos.packet.BuildSource;
import net.tinyos.packet.PhoenixSource;
import net.tinyos.util.PrintStreamMessenger;

import org.dei.perla.core.channel.Channel;
import org.dei.perla.core.channel.ChannelException;
import org.dei.perla.core.channel.ChannelFactory;
import org.dei.perla.core.channel.IOHandler;
import org.dei.perla.core.descriptor.ChannelDescriptor;
import org.dei.perla.core.descriptor.InvalidDeviceDescriptorException;

public class TinyosChannelFactory implements ChannelFactory {

	private TinyosServerListener tosListener;

	public TinyosChannelFactory(String comm) {
		try {
			initializeListener(comm);
		} catch (Exception e) {
			throw new ChannelException(
					"Error while initializing TinyOS Listener");
		}
	}

	@Override
	public Class<? extends ChannelDescriptor> acceptedChannelDescriptorClass() {
		return TinyosChannelDescriptor.class;
	}

	@Override
	public Channel createChannel(ChannelDescriptor descriptor)
			throws InvalidDeviceDescriptorException {

		System.out.println("creating channel");
		if (!(descriptor instanceof TinyosChannelDescriptor)) {
			String message = "Cannot create TinyosChannel. ";
			throw new InvalidDeviceDescriptorException(message);
		}
		TinyosChannelDescriptor tosDesc = (TinyosChannelDescriptor) descriptor;
		TinyosChannel toc = new TinyosChannel(tosDesc.getMoteId(), tosListener);
		tosListener.addChannel(toc);
		return toc;
	}

	public void addDescriptorHandler(IOHandler handler) {
		this.tosListener.addDescriptorHandler(handler);
	}

	public void initializeListener(String comm) throws Exception {
		MoteIF mif;
		PhoenixSource phoenix;

		if (comm == null) {
			phoenix = BuildSource.makePhoenix(PrintStreamMessenger.err);
		} else {
			phoenix = BuildSource.makePhoenix(comm, PrintStreamMessenger.err);
		}
		mif = new MoteIF(phoenix);
		this.tosListener = new TinyosServerListener(mif);
	}

}
