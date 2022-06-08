package ebookstore.ui;

import ebookstore.net.NetServer;

/**
 * 服务器的界面
 */
public class ServerUI {


    private NetServer netServer = new NetServer();

    private int port;

    public ServerUI(int port){
        this.port = port;
        System.out.println("电子图书商城系统正在启动...");
        System.out.println("服务器已启动");
        try {
            netServer.start(port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try {
            new ServerUI(8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
