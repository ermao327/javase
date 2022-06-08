package pattern.singleton;
/**
 * 懒汉式
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;
    private LazySingleton(){

    }
    public synchronized static LazySingleton getInstance(){
        if(null == lazySingleton){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }
}
