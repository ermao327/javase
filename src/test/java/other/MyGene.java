package other;

import java.util.ArrayList;
import java.util.List;

public class MyGene<T,A,B extends Number> {

    private T t;

    private A a;

    private B b;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    //泛型方法
    public <K> K method(K k){
        return k;
    }

    public void myMethod(List<?> list){
        final Object o = list.get(0);
    }

    public static void main(String[] args) {
        MyGene<String,Integer,Long> myGene = new MyGene<>();
        myGene.setT("111");
        myGene.setA(222);
        myGene.setB(888L);
        String t = myGene.getT();
        final Integer a = myGene.getA();
        final Long b = myGene.getB();
        final String aaa = myGene.method("aaa");

//        List list = new ArrayList<>();

        myGene.myMethod(new ArrayList<>());
    }
}
