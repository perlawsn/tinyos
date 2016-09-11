package org.dei.perla.channel.tinyos;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsefulMethodTest {

	@Test
	public void test() {
		String s="ciao come vababbb";
		short[] sa=UsefulMethods.ByteToShorts(s.getBytes());
		byte[] ba=UsefulMethods.ShortToByte_ByteBuffer_Method(sa);
		String str=new String(ba);
		assertTrue(s.equals(str));
	}

}
