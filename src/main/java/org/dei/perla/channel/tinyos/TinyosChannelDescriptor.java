package org.dei.perla.channel.tinyos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.dei.perla.core.descriptor.ChannelDescriptor;

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class TinyosChannelDescriptor extends ChannelDescriptor {

	@XmlAttribute(required = true, name = "mote-id")
	private int moteId;

	public TinyosChannelDescriptor() {
	}

	public TinyosChannelDescriptor(String id, int moteId) {
		super(id);
		this.moteId = moteId;
	}

	public int getMoteId() {
		return moteId;
	}

}
