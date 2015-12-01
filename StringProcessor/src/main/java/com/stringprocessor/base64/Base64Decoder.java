package com.stringprocessor.base64;

import com.stringprocessor.AbstractStringProcessor;
import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;

import javax.xml.bind.DatatypeConverter;

public class Base64Decoder extends AbstractStringProcessor {
    public Base64Decoder() {
        super();
    }

    public Base64Decoder(IStringProcessor next) {
        super(next);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        buffer.setBytes(DatatypeConverter.parseBase64Binary(buffer.getString()));
        
        if (next() != null) {
            buffer = next().process(buffer);
        }
        
        return buffer;
    }
 
    
}