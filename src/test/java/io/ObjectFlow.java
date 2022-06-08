package io;

import java.io.*;

/**
 * 将对象转成字节流-序列化
 * 将字节流转成对象-反序列化
 * JDK自带的序列化
 * TestSerialized
 * 类对象需要实现Serializable接口
 */
public class ObjectFlow {
    public static void main(String[] args) {
        try(final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.txt"));
            final ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dog.txt"))
        ) {
            final Dog d1 = new Dog("张三", 123);
            oos.writeObject(d1);
            final Dog o =(Dog)ois.readObject();
            System.out.println(o);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
