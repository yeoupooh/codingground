package com.stringprocessor.crypto;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.DummyStringProcessor;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.TestData;
import com.stringprocessor.base64.Base64Decoder;
import junit.framework.TestCase;

/**
 * AES Decryption Tests
 */
public class AESDecryptTest extends TestCase {

    public void testProcess() throws Exception {
        ByteBuffer buffer = new ByteBuffer(TestData.TEST_AES_ENCRYPTED_AND_BASE64_ENCODED_TEXT);
        IStringProcessor sp = new DummyStringProcessor();
        sp = new AESDecrypt(sp, TestData.TEST_AES_KEY);
        sp = new Base64Decoder(sp);
        String actual = sp.process(buffer).getString();
        assertEquals(TestData.TEST_CLEAN_TEXT, actual);
    }

}