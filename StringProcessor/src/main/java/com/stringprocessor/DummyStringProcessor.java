package com.stringprocessor;

public class DummyStringProcessor extends AbstractStringProcessor {
    public DummyStringProcessor() {
        super(null);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        return buffer;
    }
}