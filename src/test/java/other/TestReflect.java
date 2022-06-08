package other;

import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

/**
 * 反射
 * 编译期完全不知道什么东西在干嘛
 */
public class TestReflect {
    public static void main(String[] args){
        try {
            //运行时类型识别
            Class<?> aClass = Class.forName("other.Dog");
            //得到构造器对象
            final Constructor<?> constructor = aClass.getConstructor();
            //通过构造器来产生一个Dog对象
            final Object o = constructor.newInstance();
            //无法得到不能访问到的属性
//            final Field[] fields = clazz.getFields();
            final Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(Arrays.toString(declaredFields));

            final Field nameaaa = aClass.getDeclaredField("name");
            //设置可见
            nameaaa.setAccessible(true);
            nameaaa.set(o, "aww");
            final Method method = aClass.getMethod("get" +
                    nameaaa.getName().substring(0, 1).toUpperCase() +
                    nameaaa.getName().substring(1));
            final Object name = method.invoke(o);
            System.out.println(name);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
