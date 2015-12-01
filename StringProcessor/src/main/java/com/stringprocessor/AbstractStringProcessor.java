package com.stringprocessor;

public abstract class AbstractStringProcessor implements IStringProcessor {
    private IStringProcessor mNext;
    
    public AbstractStringProcessor() {
        
    }
    
    public AbstractStringProcessor(IStringProcessor next) {
        mNext = next;
    }
    
    public IStringProcessor next() {
        return mNext;
    }
    
    abstract public ByteBuffer process(ByteBuffer buffer);
}