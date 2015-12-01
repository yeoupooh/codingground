package com.stringprocessor.test;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.TestData;
import com.stringprocessor.base64.Base64Decoder;
import com.stringprocessor.base64.Base64Encoder;
import com.stringprocessor.crypto.AESDecrypt;
import com.stringprocessor.crypto.AESEncrypt;
import com.stringprocessor.xor.XorStringProcessor;
import junit.framework.TestCase;

/**
 * Combined String Processors Tests
 */
public class StringProcessorTests extends TestCase {

    public void testAllStringProcessors() throws Exception {
        ByteBuffer input = new ByteBuffer(TestData.TEST_CLEAN_TEXT);
        IStringProcessor enc;
        enc = new DummyStringProcessor();
        enc = new Base64Encoder(enc);
        enc = new XorStringProcessor(enc, TestData.TEST_XOR_KEY);
        enc = new AESEncrypt(enc, TestData.TEST_AES_KEY);

        System.out.println(enc.process(input).getString());

        IStringProcessor dec;
        dec = new DummyStringProcessor();
        dec = new AESDecrypt(dec, TestData.TEST_AES_KEY);
        dec = new XorStringProcessor(dec, TestData.TEST_XOR_KEY);
        dec = new Base64Decoder(dec);

        String actual = dec.process(input).getString();
        System.out.println(actual);

        assertEquals(TestData.TEST_CLEAN_TEXT, actual);
    }
}
