package Socket.V2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7665);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            NetMsg firstRop = (NetMsg) in.readObject();
            String myName = firstRop.getData();
            //负责读
            new Thread(() -> {
                try {
                    while (true) {
                        NetMsg response = (NetMsg) in.readObject();
                        System.out.println(response.getFrom() + "对" + response.getTo() + "说:" + response.getData());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();
            //负责写
            while (true) {
                String msg = input.next();
                String to = msg.substring(0, msg.indexOf("#"));
                String data = msg.substring(msg.indexOf("#")+1);
                NetMsg request = new NetMsg(myName, to, data);
                out.writeObject(request);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
