package Socket.V1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
             ServerSocket server = new ServerSocket(7788);
            System.out.println("服务器已启动");
            Vector<PrintWriter> clients=new Vector<>();
            //写消息
            new Thread(() -> {
                while (true) {
                    String msg=scanner.nextLine();
                    clients.forEach(out->out.println(msg));
                }
            }
            ).start();
            while (true) {
                //一直等待客户端连接我，会处于阻塞状态，至少有一个客户端连接上后，就会解除阻塞
                Socket socket = server.accept();
                System.out.println("某个客户端已连接");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                clients.add(out);

                new Thread(()->{
                    //读消息
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println(msg);
                    }
                }

                ).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
