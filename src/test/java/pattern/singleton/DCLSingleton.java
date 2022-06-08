package pattern.singleton;
/**
 * Double-Check-Lock 双检锁懒汉式
 * 1.延迟加载
 * 2.并发安全
 * 3.并发性能很好
 */
public class DCLSingleton {
    private static DCLSingleton dclSingleton;
    private DCLSingleton(){

    }
    public static DCLSingleton getInstance(){
        if(null==dclSingleton){
            synchronized (DCLSingleton.class){
                if(null==dclSingleton){
                    dclSingleton=new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
