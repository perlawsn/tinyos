package org.dei.perla.channel.tinyos;
import java.util.Optional;

import org.dei.perla.core.channel.Channel;
import org.dei.perla.core.channel.Payload;
import org.junit.BeforeClass;
import org.junit.Test;

public class TinyOsInitializerChannelTest {

	
	@BeforeClass
	public static void setupTest() throws Exception {
		TinyosChannelDescriptor descriptor1=new TinyosChannelDescriptor("1", 1);
		TinyosChannelDescriptor descriptor2=new TinyosChannelDescriptor("2",2);
		TinyosChannelDescriptor descriptor3=new TinyosChannelDescriptor("3",3);
		TinyosChannelDescriptor descriptor4=new TinyosChannelDescriptor("4",4);
		TinyosChannelDescriptor descriptor5=new TinyosChannelDescriptor("5",5);
		System.out.println("Inizializzati descrittori");
		
		TinyosChannelFactory tosFactory=new TinyosChannelFactory("sf@localhost:9002");
		SynchronizerIOHandler descriptorHandler=new SynchronizerIOHandler();
		
		System.out.println("Inizializzata factory");
		
		tosFactory.addDescriptorHandler(descriptorHandler);
		Channel channel1= tosFactory.createChannel(descriptor1);
		Channel channel2= tosFactory.createChannel(descriptor2);
		Channel channel3= tosFactory.createChannel(descriptor3);
		Channel channel4= tosFactory.createChannel(descriptor4);
		Channel channel5= tosFactory.createChannel(descriptor5);
		System.out.println("Inizializzati canali");
		
		SynchronizerIOHandler handler1 = new SynchronizerIOHandler();
		SynchronizerIOHandler handler2 = new SynchronizerIOHandler();
		SynchronizerIOHandler handler3 = new SynchronizerIOHandler();
		SynchronizerIOHandler handler4 = new SynchronizerIOHandler();
		SynchronizerIOHandler handler5 = new SynchronizerIOHandler();
		System.out.println("Inizializzati sincro");
		channel1.setAsyncIOHandler(handler1);
		channel2.setAsyncIOHandler(handler2);
		channel3.setAsyncIOHandler(handler3);
		channel4.setAsyncIOHandler(handler4);
		channel5.setAsyncIOHandler(handler5);
		
		Optional<Payload> optDesc = descriptorHandler.getResult();
		optDesc.ifPresent((descrPayload) -> {
			System.out.println(descrPayload.asString());
		});
		
		handler1.getResult();
		handler2.getResult();
		handler3.getResult();
		handler4.getResult();
		handler5.getResult();
	}
	@Test
	public void TinyosFactoryTest(){

		
		
	}
	
}
