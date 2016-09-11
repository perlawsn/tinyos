package org.dei.perla.channel.tinyos;
/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'TestSerialMsg'
 * message type.
 */

public class TinyosSerialMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 28;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 137;

    /** Create a new TestSerialMsg of size 28. */
    public TinyosSerialMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new TestSerialMsg of the given data_length. */
    public TinyosSerialMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg with the given data_length
     * and base offset.
     */
    public TinyosSerialMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg using the given byte array
     * as backing store.
     */
    public TinyosSerialMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public TinyosSerialMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public TinyosSerialMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg embedded in the given message
     * at the given base offset.
     */
    public TinyosSerialMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TestSerialMsg embedded in the given message
     * at the given base offset and length.
     */
    public TinyosSerialMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <TestSerialMsg> \n";
      try {
        s += "  [pHeader.id=0x"+Long.toHexString(get_pHeader_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pHeader.timestamp=0x"+Long.toHexString(get_pHeader_timestamp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pHeader.type=0x"+Long.toHexString(get_pHeader_type())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pHeader.numPckt=0x"+Long.toHexString(get_pHeader_numPckt())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pHeader.numPcktToSend=0x"+Long.toHexString(get_pHeader_numPcktToSend())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pPayload.data=";
        for (int i = 0; i < 18; i++) {
          s += "0x"+Long.toHexString(getElement_pPayload_data(i) & 0xff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pHeader.id
    //   Field type: int
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pHeader.id' is signed (false).
     */
    public static boolean isSigned_pHeader_id() {
        return false;
    }

    /**
     * Return whether the field 'pHeader.id' is an array (false).
     */
    public static boolean isArray_pHeader_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pHeader.id'
     */
    public static int offset_pHeader_id() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pHeader.id'
     */
    public static int offsetBits_pHeader_id() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'pHeader.id'
     */
    public int get_pHeader_id() {
        return (int)getUIntBEElement(offsetBits_pHeader_id(), 16);
    }

    /**
     * Set the value of the field 'pHeader.id'
     */
    public void set_pHeader_id(int value) {
        setUIntBEElement(offsetBits_pHeader_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pHeader.id'
     */
    public static int size_pHeader_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pHeader.id'
     */
    public static int sizeBits_pHeader_id() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pHeader.timestamp
    //   Field type: int
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pHeader.timestamp' is signed (false).
     */
    public static boolean isSigned_pHeader_timestamp() {
        return false;
    }

    /**
     * Return whether the field 'pHeader.timestamp' is an array (false).
     */
    public static boolean isArray_pHeader_timestamp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pHeader.timestamp'
     */
    public static int offset_pHeader_timestamp() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pHeader.timestamp'
     */
    public static int offsetBits_pHeader_timestamp() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'pHeader.timestamp'
     */
    public int get_pHeader_timestamp() {
        return (int)getUIntBEElement(offsetBits_pHeader_timestamp(), 16);
    }

    /**
     * Set the value of the field 'pHeader.timestamp'
     */
    public void set_pHeader_timestamp(int value) {
        setUIntBEElement(offsetBits_pHeader_timestamp(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pHeader.timestamp'
     */
    public static int size_pHeader_timestamp() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pHeader.timestamp'
     */
    public static int sizeBits_pHeader_timestamp() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pHeader.type
    //   Field type: int
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pHeader.type' is signed (false).
     */
    public static boolean isSigned_pHeader_type() {
        return false;
    }

    /**
     * Return whether the field 'pHeader.type' is an array (false).
     */
    public static boolean isArray_pHeader_type() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pHeader.type'
     */
    public static int offset_pHeader_type() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pHeader.type'
     */
    public static int offsetBits_pHeader_type() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'pHeader.type'
     */
    public int get_pHeader_type() {
        return (int)getUIntBEElement(offsetBits_pHeader_type(), 16);
    }

    /**
     * Set the value of the field 'pHeader.type'
     */
    public void set_pHeader_type(int value) {
        setUIntBEElement(offsetBits_pHeader_type(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pHeader.type'
     */
    public static int size_pHeader_type() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pHeader.type'
     */
    public static int sizeBits_pHeader_type() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pHeader.numPckt
    //   Field type: int
    //   Offset (bits): 48
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pHeader.numPckt' is signed (false).
     */
    public static boolean isSigned_pHeader_numPckt() {
        return false;
    }

    /**
     * Return whether the field 'pHeader.numPckt' is an array (false).
     */
    public static boolean isArray_pHeader_numPckt() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pHeader.numPckt'
     */
    public static int offset_pHeader_numPckt() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pHeader.numPckt'
     */
    public static int offsetBits_pHeader_numPckt() {
        return 48;
    }

    /**
     * Return the value (as a int) of the field 'pHeader.numPckt'
     */
    public int get_pHeader_numPckt() {
        return (int)getUIntBEElement(offsetBits_pHeader_numPckt(), 16);
    }

    /**
     * Set the value of the field 'pHeader.numPckt'
     */
    public void set_pHeader_numPckt(int value) {
        setUIntBEElement(offsetBits_pHeader_numPckt(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pHeader.numPckt'
     */
    public static int size_pHeader_numPckt() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pHeader.numPckt'
     */
    public static int sizeBits_pHeader_numPckt() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pHeader.numPcktToSend
    //   Field type: int
    //   Offset (bits): 64
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pHeader.numPcktToSend' is signed (false).
     */
    public static boolean isSigned_pHeader_numPcktToSend() {
        return false;
    }

    /**
     * Return whether the field 'pHeader.numPcktToSend' is an array (false).
     */
    public static boolean isArray_pHeader_numPcktToSend() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pHeader.numPcktToSend'
     */
    public static int offset_pHeader_numPcktToSend() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pHeader.numPcktToSend'
     */
    public static int offsetBits_pHeader_numPcktToSend() {
        return 64;
    }

    /**
     * Return the value (as a int) of the field 'pHeader.numPcktToSend'
     */
    public int get_pHeader_numPcktToSend() {
        return (int)getUIntBEElement(offsetBits_pHeader_numPcktToSend(), 16);
    }

    /**
     * Set the value of the field 'pHeader.numPcktToSend'
     */
    public void set_pHeader_numPcktToSend(int value) {
        setUIntBEElement(offsetBits_pHeader_numPcktToSend(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pHeader.numPcktToSend'
     */
    public static int size_pHeader_numPcktToSend() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pHeader.numPcktToSend'
     */
    public static int sizeBits_pHeader_numPcktToSend() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pPayload.data
    //   Field type: short[]
    //   Offset (bits): 80
    //   Size of each element (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pPayload.data' is signed (false).
     */
    public static boolean isSigned_pPayload_data() {
        return false;
    }

    /**
     * Return whether the field 'pPayload.data' is an array (true).
     */
    public static boolean isArray_pPayload_data() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'pPayload.data'
     */
    public static int offset_pPayload_data(int index1) {
        int offset = 80;
        if (index1 < 0 || index1 >= 18) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pPayload.data'
     */
    public static int offsetBits_pPayload_data(int index1) {
        int offset = 80;
        if (index1 < 0 || index1 >= 18) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return offset;
    }

    /**
     * Return the entire array 'pPayload.data' as a short[]
     */
    public short[] get_pPayload_data() {
        short[] tmp = new short[18];
        for (int index0 = 0; index0 < numElements_pPayload_data(0); index0++) {
            tmp[index0] = getElement_pPayload_data(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'pPayload.data' from the given short[]
     */
    public void set_pPayload_data(short[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_pPayload_data(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a short) of the array 'pPayload.data'
     */
    public short getElement_pPayload_data(int index1) {
        return (short)getUIntBEElement(offsetBits_pPayload_data(index1), 8);
    }

    /**
     * Set an element of the array 'pPayload.data'
     */
    public void setElement_pPayload_data(int index1, short value) {
        setUIntBEElement(offsetBits_pPayload_data(index1), 8, value);
    }

    /**
     * Return the total size, in bytes, of the array 'pPayload.data'
     */
    public static int totalSize_pPayload_data() {
        return (144 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'pPayload.data'
     */
    public static int totalSizeBits_pPayload_data() {
        return 144;
    }

    /**
     * Return the size, in bytes, of each element of the array 'pPayload.data'
     */
    public static int elementSize_pPayload_data() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'pPayload.data'
     */
    public static int elementSizeBits_pPayload_data() {
        return 8;
    }

    /**
     * Return the number of dimensions in the array 'pPayload.data'
     */
    public static int numDimensions_pPayload_data() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'pPayload.data'
     */
    public static int numElements_pPayload_data() {
        return 18;
    }

    /**
     * Return the number of elements in the array 'pPayload.data'
     * for the given dimension.
     */
    public static int numElements_pPayload_data(int dimension) {
      int array_dims[] = { 18,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /**
     * Fill in the array 'pPayload.data' with a String
     */
    public void setString_pPayload_data(String s) { 
         int len = s.length();
         int i;
         for (i = 0; i < len; i++) {
             setElement_pPayload_data(i, (short)s.charAt(i));
         }
         setElement_pPayload_data(i, (short)0); //null terminate
    }

    /**
     * Read the array 'pPayload.data' as a String
     */
    public String getString_pPayload_data() { 
         char carr[] = new char[Math.min(net.tinyos.message.Message.MAX_CONVERTED_STRING_LENGTH,18)];
         int i;
         for (i = 0; i < carr.length; i++) {
             if ((char)getElement_pPayload_data(i) == (char)0) break;
             carr[i] = (char)getElement_pPayload_data(i);
         }
         return new String(carr,0,i);
    }

}
