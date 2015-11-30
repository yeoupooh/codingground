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
    
    public abstract StringHolder process(StringHolder holder);
    
    public StringHolder doProcess(StringHolder holder, int mode) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(mode, getSecretKeySpec());
            holder.setBytes(cipher.doFinal(holder.getBytes()));
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
            holder = next().process(holder);
        }      
        
        return holder;        
    }
}