package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedWriter {
    public static void main(String[] args) {
        try(final BufferedWriter out = new BufferedWriter(new FileWriter("bbb.txt"))){
            out.write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
