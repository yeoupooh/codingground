import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.InvalidKeyException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.print.DocFlavor.STRING;

public class AESDecrypt extends AbstractAES {
    public AESDecrypt(IStringProcessor next, byte[] key) {
        super(next, key);
    }
    
    public StringHolder process(StringHolder holder) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        
        return doProcess(holder, Cipher.DECRYPT_MODE);
    }
    
}
