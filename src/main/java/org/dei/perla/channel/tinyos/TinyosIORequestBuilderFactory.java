package org.dei.perla.channel.tinyos;

import org.dei.perla.core.channel.IORequestBuilder;
import org.dei.perla.core.channel.IORequestBuilderFactory;

import org.dei.perla.core.descriptor.IORequestDescriptor;
import org.dei.perla.core.descriptor.InvalidDeviceDescriptorException;
import org.dei.perla.core.utils.Check;
import org.dei.perla.core.utils.Errors;

public class TinyosIORequestBuilderFactory implements IORequestBuilderFactory {

	@Override
	public Class<? extends IORequestDescriptor> acceptedIORequestClass() {

		return TinyosIORequestDescriptor.class;
	}

	@Override
	public IORequestBuilder create(IORequestDescriptor descriptor)
			throws InvalidDeviceDescriptorException {

		String reqId;
		if (!(descriptor instanceof TinyosIORequestDescriptor)) {
			String message = String.format("Expected "
					+ TinyosIORequestDescriptor.class.getCanonicalName()
					+ " but received "
					+ descriptor.getClass().getCanonicalName() + ".");

			throw new InvalidDeviceDescriptorException(message);
		}

		reqId = descriptor.getId();

		return new TinyosIORequestBuilder(reqId);
	}

}
