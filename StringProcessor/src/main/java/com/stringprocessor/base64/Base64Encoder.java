package com.stringprocessor.base64;//import org.apache.commons.codec.binary.Base64;
import com.stringprocessor.AbstractStringProcessor;
import com.stringprocessor.ByteBuffer;
import com.stringprocessor.IStringProcessor;

import javax.xml.bind.DatatypeConverter;

public class Base64Encoder extends AbstractStringProcessor implements IStringProcessor {

    public Base64Encoder() {
        super();
    }

    public Base64Encoder(IStringProcessor next) {
        super(next);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        buffer.setString(DatatypeConverter.printBase64Binary(buffer.getBytes()));
        
        if (next() != null) {
            buffer = next().process(buffer);
        }
        
        return buffer;
    }
    
}