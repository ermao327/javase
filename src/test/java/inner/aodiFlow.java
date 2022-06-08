package inner;

import java.io.*;

public class aodiFlow {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("car.txt"));
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("car.txt"))
        ){
            oos.writeObject(new aodi("奥迪", "A6", "白色",
                    "米其林", 60));
            aodi aodi1 = (aodi) ois.readObject();
            System.out.println(aodi1);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
