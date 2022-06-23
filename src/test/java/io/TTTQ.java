package io;

import java.io.*;
import java.util.Arrays;

public class TTTQ {
    //定义一个数组，如int[]arr={12,24,18,20},把数组里的数据写入某个文件中，并读取出来打印到控制台，要求按倒序方式打印输出，如输出结果为{20,18,24,12}
    public static void main(String[] args) throws IOException {
        int[] arr = {12, 24, 18, 20};
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        final File file = new File("d:\\array.txt");
        final FileWriter out = new FileWriter(file);
        for (int i = 0; i < arr1.length; i++) {
            out.write(arr1[i] + ",");
        }
        out.close();
        final BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] str = line.split(",");
            for (int i = 0; i < str.length; i++) {
                arr2[i] = Integer.parseInt(str[i]);
            }
        }
        in.close();

        for (int i = 0; i < arr2.length/2; i++) {
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length-1-i];
            arr2[arr2.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr2));
    }
}
