public class StringHolder {
    // private String mStr;
    private byte[] mBytes;
    
    public StringHolder(String str) {
        //mStr = str;
        mBytes = str.getBytes();
    }
    
    public String getString() {
        // return mStr;
        return new String(mBytes);
    }
    
    public void setString(String str) {
        // mStr = str;
        mBytes = str.getBytes();
    }
    
    public byte[] getBytes() {
        // return mStr.getBytes();
        return mBytes;
    }
    
    public void setBytes(byte[] bytes) {
        // mStr = new String(bytes);
        mBytes = bytes;
    }
}