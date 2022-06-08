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

public class Server {
    public static void main(String[] args) {
        try {
            final ServerSocket server = new ServerSocket(7665);
            System.out.println("服务器已启动");
            final Scanner input = new Scanner(System.in);
            ConcurrentHashMap<String, ObjectOutputStream> clientMap = new ConcurrentHashMap<>();
            final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                    100, 100, 0,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
            //负责写
            new Thread(() -> {
                while (true) {
                    String msg = input.next();
                    NetMsg response = new NetMsg("服务器", "客户端", msg);
                    clientMap.values().forEach(out->{
                        try {
                            out.writeObject(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }).start();
            int clientIndex = 1;
            while(true) {
                Socket socket = server.accept();
                System.out.println("某个客户端已经连接上");
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                clientMap.put(clientIndex+"", out);
                //发送客户端的名字
                out.writeObject(new NetMsg("服务器", "客户端", clientIndex+""));
                clientIndex++;
                poolExecutor.execute(()->{
                    try {
                        //负责读
                        while (true) {
                            NetMsg request = (NetMsg) in.readObject();
                            String from = request.getFrom();
                            String to = request.getTo();
                            String data = request.getData();
                            System.out.println(request.getFrom() + "对" + request.getTo() + "说:" + request.getData());
                            //将消息转发给所有人
                            if(to.equals("0")){
                                clientMap.values().forEach(out2->{
                                    try {
                                        out2.writeObject(new NetMsg(from,"所有人", data));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            //发给某一个客户端
                            else{
                                clientMap.get(to).writeObject(new NetMsg(from, to, data));
                            }
                        }
                    }catch (IOException | ClassNotFoundException e){
                        e.printStackTrace();
                    }
                });
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
