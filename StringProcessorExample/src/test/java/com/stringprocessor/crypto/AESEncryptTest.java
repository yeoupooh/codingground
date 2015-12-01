package com.stringprocessor.crypto;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.TestData;
import com.stringprocessor.base64.Base64Encoder;
import junit.framework.TestCase;

/**
 * AES Encryption Tests
 */
public class AESEncryptTest extends TestCase {

    public void testProcess() throws Exception {
        ByteBuffer buffer = new ByteBuffer(TestData.TEST_CLEAN_TEXT);
        IStringProcessor sp = new DummyStringProcessor();
        sp = new Base64Encoder(sp);
        sp = new AESEncrypt(sp, TestData.TEST_AES_KEY);
        String actual = sp.process(buffer).getString();
        assertEquals(TestData.TEST_AES_ENCRYPTED_AND_BASE64_ENCODED_TEXT, actual);
    }
}