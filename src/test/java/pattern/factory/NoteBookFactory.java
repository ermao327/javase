package pattern.factory;

public class NoteBookFactory {

    public static Notebook produce(String band){
        if("thinkpad".equals(band)){
            return new Thinkpad();
        }
        if("macbook".equals(band)){
            return new Macbook();
        }
        if("matebook".equals(band)){
            return new Matebook();
        }
        return null;
    }

    public static void main(String[] args) {
        final Notebook macbook = NoteBookFactory.produce("matebook");
        macbook.compute();
    }
}
