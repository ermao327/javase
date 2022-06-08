package io;

import java.io.FileOutputStream;

public class TryWithResource {
    public static void main(String[] args) {
        try (
            FileOutputStream out = new FileOutputStream("bbb.txt");
        ){
            out.write("abcdefg".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
