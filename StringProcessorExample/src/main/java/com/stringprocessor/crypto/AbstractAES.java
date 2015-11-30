package com.stringprocessor.crypto;

import com.stringprocessor.AbstractStringProcessor;
import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public abstract class AbstractAES extends AbstractStringProcessor {
    private SecretKeySpec mSecretKeySpec;
    
    public AbstractAES(byte[] key) {
        this(null, key);
    }
    
    public AbstractAES(IStringProcessor next, byte[] key) {
        super(next);
                
        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            mSecretKeySpec = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        mSecretKeySpec = new SecretKeySpec(key, "AES");
    }
    
    public SecretKeySpec getSecretKeySpec() {
        return mSecretKeySpec;
    }
    
    public abstract ByteBuffer process(ByteBuffer buffer);
    
    public ByteBuffer doProcess(ByteBuffer buffer, int mode) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(mode, getSecretKeySpec());
            buffer.setBytes(cipher.doFinal(buffer.getBytes()));
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();    
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        if (next() != null) {
            buffer = next().process(buffer);
        }      
        
        return buffer;
    }
}