package com.stringprocessor;

public class ByteBuffer {
    private byte[] mBytes;

    public ByteBuffer(String str) {
        mBytes = str.getBytes();
    }

    public String getString() {
        return new String(mBytes);
    }

    public void setString(String str) {
        mBytes = str.getBytes();
    }

    public byte[] getBytes() {
        return mBytes;
    }

    public void setBytes(byte[] bytes) {
        mBytes = bytes;
    }
}