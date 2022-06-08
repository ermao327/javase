package pattern.proxy.jdk;


import pattern.proxy.stat.Target2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.用的反射技术(实现可以代理任何类型的对象)
 * 2.JDK动态代理所代理的类必须实现某个接口
 * 3.代理类和目标类事实上是兄弟关系，它们实现了同一个接口
 * Spring框架中会用到
 */
public class JDKProxy implements InvocationHandler {

    //可以绑定代理任何对象
    private Object target;

    public Object bind(Object target){
        this.target = target;
        //会返回一个代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        //调用目标对象的方法
        final Object result = method.invoke(target);
        System.out.println("后置增强");
        return result;
    }

    public static void main(String[] args) {
        Target2 target2 = new Target2();
        final Target2 proxy = (Target2)new JDKProxy().bind(target2);
        proxy.method();
    }
}
