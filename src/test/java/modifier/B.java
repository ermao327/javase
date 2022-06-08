package modifier;

public class B {
    public  void  say(){
        A a = new A();
        //同包私有修饰属性或方法不能访问
        System.out.println("n1="+a.n1+"n2="+a.n2+"n3="+a.n3+"n4=");
    }
}
