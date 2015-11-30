public class HelloWorld{

    public static void main(String []args) {
        String expected = "HelloWorld";
        StringHolder input = new StringHolder(expected);
        String keyStr = "cipher4tcm";
        IStringProcessor enc;
        enc = new DummyStringProcessor();
        enc = new Base64Encoder(enc);
        enc = new AESEncrypt(enc, keyStr.getBytes());
        
        System.out.println(enc.process(input).getString());
        
        IStringProcessor dec;
        dec = new DummyStringProcessor();
        dec = new AESDecrypt(dec, keyStr.getBytes());
        dec = new Base64Decoder(dec);
        
        String actual = dec.process(input).getString();
        System.out.println(actual);
        System.out.println(expected.equals(actual) ? "YES" : "NO"); 
    }
}
