package com.stringprocessor.crypto;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;

import javax.crypto.Cipher;

public class AESDecrypt extends AbstractAES {
    public AESDecrypt(IStringProcessor next, byte[] key) {
        super(next, key);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        return doProcess(buffer, Cipher.DECRYPT_MODE);
    }
    
}
