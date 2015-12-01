package com.stringprocessor.base64;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.TestData;
import junit.framework.TestCase;

/**
 * Base64 Decoder Tests
 */
public class Base64DecoderTest extends TestCase {

    public void testProcess() throws Exception {
        ByteBuffer buffer = new ByteBuffer(TestData.TEST_BASE64_ENCODED_TEXT);
        IStringProcessor sp = new DummyStringProcessor();
        sp = new Base64Decoder(sp);
        String actual = sp.process(buffer).getString();
        assertEquals(TestData.TEST_CLEAN_TEXT, actual);
    }

}