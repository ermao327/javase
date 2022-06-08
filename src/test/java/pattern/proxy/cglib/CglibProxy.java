package pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理的是类
 * 利用的是字节码技术
 * 运行的时候会帮你写一个代理类，同时生成对象
 */
public class CglibProxy implements MethodInterceptor{

	public Object bind(Object target) {
		Enhancer eh = new Enhancer();
		eh.setSuperclass(target.getClass());  
		eh.setCallback(this);
		return eh.create();
	}

	@Override
	public Object intercept(Object obj, Method method,
			Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("前置增强");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("后置增强");
		return result;
	}
		
}
