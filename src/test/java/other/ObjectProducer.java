package other;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

public class ObjectProducer {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("object.properties"));
//        System.out.println(properties);
        String className = properties.getProperty("class.name");
        final Class<?> clazz = Class.forName(className);
        final Constructor<?> constructor = clazz.getConstructor();
        final Object obj = constructor.newInstance();
//        System.out.println(properties.keySet());
        Set<Object> keySet = properties.keySet();
        for (Object o : keySet) {
            String key = (String) o;
            if(key.startsWith("field")){
                String fieldName = key.split("\\.")[1];
                final String fieldValue = properties.getProperty(key);
                System.out.println("fValue="+fieldValue);
                Field field = clazz.getDeclaredField(fieldName);
                System.out.println("type="+field.getType());
                field.setAccessible(true);
                String setterName = "set"+
                        fieldName.substring(0, 1).toUpperCase()
                        +fieldName.substring(1);
                Method setterMethod = clazz.getMethod(setterName,field.getType());
                if("int".equals(field.getType().getSimpleName())){
                    setterMethod.invoke(obj,Integer.parseInt(fieldValue));
                }else {
                    setterMethod.invoke(obj, fieldValue);
                }
            }
        }
        System.out.println(obj);
//        final String property1 = properties.getProperty("field.name");
//        final String property2 = properties.getProperty("field.age");
//        final String property3 = properties.getProperty("field.weight");
    }
}
