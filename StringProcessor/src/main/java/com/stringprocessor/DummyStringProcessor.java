package com.stringprocessor;

public class DummyStringProcessor extends AbstractStringProcessor {
    public DummyStringProcessor() {
        super(null);
    }
    
    public ByteBuffer process(ByteBuffer buffer) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        return buffer;
    }
}