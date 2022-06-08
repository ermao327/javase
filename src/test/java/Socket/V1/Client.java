package Socket.V1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
             Socket socket = new Socket("192.168.71.8",7788);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
             Scanner scanner = new Scanner(System.in);
            //读消息
            new Thread(()->{
                while (true){
                    String msg = in.nextLine();
                    System.out.println(msg);
                }
            }
            ).start();
            //写消息
            while (true){
                out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
