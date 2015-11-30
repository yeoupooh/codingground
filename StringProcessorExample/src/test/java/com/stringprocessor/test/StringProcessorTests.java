package com.stringprocessor.test;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.base64.Base64Decoder;
import com.stringprocessor.base64.Base64Encoder;
import com.stringprocessor.crypto.AESDecrypt;
import com.stringprocessor.crypto.AESEncrypt;
import junit.framework.TestCase;

/**
 * Created by yeoupooh on 11/30/15.
 */
public class StringProcessorTests extends TestCase {

    public void testAll() throws Exception {
        String expected = "HelloWorld";
        ByteBuffer input = new ByteBuffer(expected);
        String keyStr = "mysecretkey";
        IStringProcessor enc;
        enc = new DummyStringProcessor();
        enc = new Base64Encoder(enc);
        enc = new AESEncrypt(enc, keyStr.getBytes());

        System.out.println(enc.process(input).getString());

        IStringProcessor dec;
        dec = new DummyStringProcessor();
        dec = new AESDecrypt(dec, keyStr.getBytes());
        dec = new Base64Decoder(dec);

        String actual = dec.process(input).getString();
        System.out.println(actual);

        assertEquals(expected, actual);
    }
}
