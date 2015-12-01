package com.stringprocessor.xor;

import com.stringprocessor.AbstractStringProcessor;
import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;

/**
 * XOR String Processor
 */
public class XorStringProcessor extends AbstractStringProcessor {

    private final byte mKey;

    public XorStringProcessor(IStringProcessor sp, byte key) {
        super(sp);
        mKey = key;
    }

    @Override
    public ByteBuffer process(ByteBuffer buffer) {
        byte[] bytes = buffer.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(bytes[i] ^ mKey);
        }

        if (next() != null) {
            buffer = next().process(buffer);
        }

        return buffer;
    }
}
