package ebookstore.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetClient {

    private  ObjectInputStream ois;
    private ObjectOutputStream oos;
    public NetClient(){

    }

    public void start(String ip,int port) throws Exception {
        Socket socket = new Socket(ip, port);
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public NetMsg send(NetMsg request) throws Exception {
        this.oos.writeObject(request);//向服务器发送请求
        return (NetMsg) ois.readObject();//收到服务器的响应
    }
}
