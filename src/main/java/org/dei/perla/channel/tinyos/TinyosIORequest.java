package org.dei.perla.channel.tinyos;

import java.security.InvalidParameterException;

import org.dei.perla.core.channel.ByteArrayPayload;
import org.dei.perla.core.channel.IORequest;
import org.dei.perla.core.channel.Payload;
import org.dei.perla.core.channel.http.HttpIORequestDescriptor.HttpMethod;
import org.dei.perla.core.utils.Check;

public class TinyosIORequest implements IORequest {

	private final String id;
	private Payload payload;

	public TinyosIORequest(String id) {
		super();
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setParameter(String name, Payload payload) {
		if (!name.equals("data")) {
			throw new InvalidParameterException(
					"Invalid parameter name. Expected 'data' ");
		}
		this.payload = (ByteArrayPayload) payload;
	}

	protected Payload getData() {
		return   payload;
	}
	
}
