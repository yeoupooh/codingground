import javax.xml.bind.DatatypeConverter;

public class Base64Decoder extends AbstractStringProcessor {
    public Base64Decoder() {
        super();
    }

    public Base64Decoder(IStringProcessor next) {
        super(next);
    }
    
    public StringHolder process(StringHolder holder) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        holder.setBytes(DatatypeConverter.parseBase64Binary(holder.getString()));
        
        if (next() != null) {
            holder = next().process(holder);
        }
        
        return holder;
    }
 
    
}