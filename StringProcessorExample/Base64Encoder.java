//import org.apache.commons.codec.binary.Base64;
import javax.xml.bind.DatatypeConverter;

public class Base64Encoder extends AbstractStringProcessor implements IStringProcessor {

    public Base64Encoder() {
        super();
    }

    public Base64Encoder(IStringProcessor next) {
        super(next);
    }
    
    public StringHolder process(StringHolder holder) {
        System.out.println(String.format("%s: process", this.getClass().getSimpleName()));
        holder.setString(DatatypeConverter.printBase64Binary(holder.getBytes()));
        
        if (next() != null) {
            holder = next().process(holder);
        }
        
        return holder;
    }
    
}