package org.dei.perla.channel.tinyos;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.dei.perla.core.channel.ByteArrayPayload;
import org.dei.perla.core.descriptor.ChannelDescriptor;
import org.dei.perla.core.descriptor.DeviceDescriptor;
import org.dei.perla.core.descriptor.InvalidDeviceDescriptorException;
import org.junit.BeforeClass;
import org.junit.Test;

public class TinyosDescriptorTest {
	private static DeviceDescriptor device;
	private static final String descriptorPath = "src/test/java/org/dei/perla/channel/tinyos/tos_descriptor.xml";

	@BeforeClass
	public static void descriptor() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("org.dei.perla.fpc.descriptor");
		sb.append(":org.dei.perla.fpc.descriptor.instructions");
		sb.append(":org.dei.perla.channel.tinyos");
		sb.append(":org.dei.perla.message.json");
		JAXBContext jc = JAXBContext.newInstance(sb.toString());
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		StreamSource xml = new StreamSource(descriptorPath);
		device = unmarshaller.unmarshal(xml, DeviceDescriptor.class).getValue();

	}

	@Test
	public void testChannelDescriptor() throws InvalidDeviceDescriptorException {
		assertFalse(device.getChannelList().isEmpty());
		ChannelDescriptor channelDescriptor = device.getChannelList().get(0);
		assertTrue(channelDescriptor instanceof TinyosChannelDescriptor);
		TinyosChannelDescriptor chanDescr = (TinyosChannelDescriptor) channelDescriptor;
		assertFalse(device.getRequestList().isEmpty());
		assertTrue(channelDescriptor.getId().equals("tos_ch_01"));
		assertTrue(chanDescr.getMoteId() == 1);

	}
	
	

	@Test
	public void testIORequest() {
		assertTrue(device.getRequestList().get(0).getId().equals("request"));
	}
	
	@Test
	public void testIORequestFactory() throws InvalidDeviceDescriptorException{
		TinyosIORequestBuilderFactory reqBuildFact=new TinyosIORequestBuilderFactory();
		assertTrue(device.getRequestList().get(0).getClass().equals(reqBuildFact.acceptedIORequestClass()));
		TinyosIORequestBuilder builder=(TinyosIORequestBuilder) reqBuildFact.create(device.getRequestList().get(0));
		assertTrue(builder.getRequestId().equals("request"));
		assertFalse(builder.getParameterList().isEmpty());
		assertTrue(builder.getParameterList().size()==1);
		assertTrue(builder.getParameterList().get(0).getName().equals("data"));
		TinyosIORequest ioReq=(TinyosIORequest) builder.create();
		assertTrue(ioReq.getId().equals("request"));
		ByteArrayPayload payload;
		byte[] byteArray=new byte[56];
		new Random().nextBytes(byteArray);
		payload=new ByteArrayPayload(byteArray);
		ioReq.setParameter("data", payload);
		ByteBuffer buffer = ByteBuffer.wrap(byteArray).asReadOnlyBuffer();
		assertTrue(ioReq.getData().asByteBuffer().equals(buffer));
		
	}
	
}
