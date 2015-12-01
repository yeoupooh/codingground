package com.stringprocessor.xor;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.TestData;
import com.stringprocessor.base64.Base64Decoder;
import com.stringprocessor.base64.Base64Encoder;
import junit.framework.TestCase;

/**
 * XOR String Processor Tests
 */
public class XorStringProcessorTest extends TestCase {

    public void testCharArrayConversion() throws Exception {
        char[] chars = TestData.TEST_CLEAN_TEXT.toCharArray();
        assertEquals(10, chars.length);
        assertEquals(TestData.TEST_CLEAN_TEXT, String.valueOf(chars));
    }

    public void testProcess() throws Exception {
        ByteBuffer buffer = new ByteBuffer(TestData.TEST_CLEAN_TEXT);
        IStringProcessor sp = new DummyStringProcessor();
        sp = new XorStringProcessor(sp, TestData.TEST_XOR_KEY);
        sp = new XorStringProcessor(sp, TestData.TEST_XOR_KEY);
        String actual = sp.process(buffer).getString();
        assertEquals(TestData.TEST_CLEAN_TEXT, actual);
    }

    public void testProcessWithBase64Encoding() throws Exception {
        ByteBuffer buffer = new ByteBuffer(TestData.TEST_CLEAN_TEXT);

        IStringProcessor enc = new DummyStringProcessor();
        enc = new Base64Encoder(enc);
        enc = new XorStringProcessor(enc, TestData.TEST_XOR_KEY);
        String encoded = enc.process(buffer).getString();
        assertEquals(TestData.TEST_XORED_AND_BASE64_ENCODED_TEXT, encoded);

        IStringProcessor dec = new DummyStringProcessor();
        dec = new XorStringProcessor(dec, TestData.TEST_XOR_KEY);
        dec = new Base64Decoder(dec);
        String actual = dec.process(buffer).getString();
        assertEquals(TestData.TEST_CLEAN_TEXT, actual);
    }

}