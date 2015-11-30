public class DummyStringProcessor extends AbstractStringProcessor {
    public DummyStringProcessor() {
        super(null);
    }
    
    public StringHolder process(StringHolder holder) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        return holder;
    }
}