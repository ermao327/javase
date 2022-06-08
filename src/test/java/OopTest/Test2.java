package OopTest;

public class Test2 {
    public static void main(String[] args) {
        String s="aaa";
        s=method(s);
        System.out.println(s);
    }
    public static String method(String s){
        s.concat("123");
//        System.out.println("111"+s.concat("123"));
        return s;
    }
}
