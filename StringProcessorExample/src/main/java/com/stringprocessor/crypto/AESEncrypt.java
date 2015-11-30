package com.stringprocessor.crypto;

import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;
import com.stringprocessor.crypto.AbstractAES;

import javax.crypto.Cipher;

public class AESEncrypt extends AbstractAES implements IStringProcessor {
    public AESEncrypt(IStringProcessor next, byte[] key) {
        super(next, key);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        return doProcess(buffer, Cipher.ENCRYPT_MODE);
    }
}