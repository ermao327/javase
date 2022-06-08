package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferedOutStream {
    public static void main(String[] args) {
        try(final BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("bbb.txt"))){
            out.write("abcde".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
