package org.dei.perla.channel.tinyos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class UsefulMethods {
	/**
	 * ShortToByte_ByteBuffer_Method(): It converts an array of shorts into an
	 * array of bytes. Endianness is considered
	 * 
	 * @param input
	 * @return
	 */
	static byte[] ShortToByte_ByteBuffer_Method(short[] input) {
		ByteBuffer buffer = ByteBuffer.allocate(input.length * 2);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.asShortBuffer().put(input);
		byte[] bytes = buffer.array();
		byte[] b;
		if (bytes.length%2==0){
		b=new byte[bytes.length/2];
		}
		else {
			b=new byte[(bytes.length/2)+1];
		}
		int i=0;
		for (int j = 0; j <bytes.length; j = j + 2) {
			b[i]=bytes[j];
			i++;
		}
		
		return b;
	}

	static short[] ByteToShorts(byte[] bytes) {
		short[] s = new short[bytes.length];
		byte[] b = new byte[bytes.length * 2];
		
		for (int i=0; i<b.length; i++){
			if (i%2==0){
				b[i]=bytes[i/2];
			}
			else {
				b[i]=0;
			}
		}		
		ByteBuffer bb = ByteBuffer.wrap(b);
		ShortBuffer sb = bb.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
		sb.get(s);
		return s;
	}

}
