package pattern.adapter;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        final Iterator<String> iterator = List.of("aaa", "bbb", "ccc").iterator();
    }
}
