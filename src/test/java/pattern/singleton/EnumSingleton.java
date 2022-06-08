package pattern.singleton;

public enum EnumSingleton {
    SINGLETON;
    public void method(){
        System.out.println("枚举类");
    }

    public static void main(String[] args) {
        EnumSingleton.SINGLETON.method();
    }
}
