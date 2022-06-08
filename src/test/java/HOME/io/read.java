package HOME.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class read {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("hero.txt"));
             BufferedWriter writer=new BufferedWriter(new FileWriter("heros2.txt"))
        )
        {
            String s;
            ArrayList<Hero> list=new ArrayList<>();
            while((s=reader.readLine())!=null){
                String[] split = s.split(",");
                list.add(new Hero(split[0],Integer.valueOf(split[1]),
                        split[2],split[3]));
            }
            list.sort(Comparator.comparing(Hero::getAge).reversed());
            list.forEach(hero -> {
                try {
                    writer.write(hero.getName()+","+hero.getAge()+","+
                            hero.getSex()+","+hero.getCity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
