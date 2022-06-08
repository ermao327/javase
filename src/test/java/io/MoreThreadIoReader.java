package io;

import java.io.*;
import java.util.concurrent.Callable;

public class MoreThreadIoReader implements Runnable{

    private final String type;
    private final String filename;

    public MoreThreadIoReader(String type, String filename) {
        this.type = type;
        this.filename = filename;
    }

    public static void main(String[] args) {

        String filename="aaa.txt";
        new Thread(new MoreThreadIoReader("even", filename)).start();
        new Thread(new MoreThreadIoReader("ood", filename)).start();

    }

    @Override
    public void run() {

        try(final BufferedReader in = new BufferedReader(new FileReader("aaa.txt"));
            final BufferedWriter ou = new BufferedWriter(new FileWriter(
                    filename.substring(0, filename.lastIndexOf("."))+"_"+type
            +filename.substring(filename.lastIndexOf("."))));

        ) {
            String s;int n=0;
            while((s=in.readLine())!=null){
                if(type.equals("even")&&n%2==0)
                {
                    ou.write(s);
                    ou.newLine();
                }
                else if(type.equals("ood")&&n%2==1)
                {
                    ou.write(s);
                    ou.newLine();
                }
                n++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
