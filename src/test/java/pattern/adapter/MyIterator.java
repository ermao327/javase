package pattern.adapter;

import java.util.Enumeration;

public class MyIterator {

    private Enumeration enumeration;

    public void next(){
        enumeration.nextElement();
    }
}
