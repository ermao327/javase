package io;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        //append参数，向文件尾部追加
        try(FileWriter out = new FileWriter("bbb.txt",true)){
            out.write("weiutyjshbvdwqeuirgwbdvj,sdbfwuie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
