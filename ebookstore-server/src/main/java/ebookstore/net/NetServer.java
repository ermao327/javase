package ebookstore.net;

import ebookstore.entity.OrderPub;
import ebookstore.entity.SysBook;
import ebookstore.service.SysBookService;
import ebookstore.service.SysCustomerService;
import ebookstore.service.SysOrderService;
import ebookstore.service.SysUserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * 封装Socket服务器相关的代码
 */
public class NetServer {

    public NetServer() {
    }

    public void start(int port) throws Exception {
        ServerSocket server = new ServerSocket(port);
        final Socket socket = server.accept();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //用来疯狂的收消息
        new Thread(() -> {
            try {
                while (true) {
                    final NetMsg request = (NetMsg) ois.readObject();
                    String type = request.getType();
                    //用户登录
                    if (type.startsWith("USER")) {
                        if (type.endsWith("LOGIN")) {
                            //处理用户登录的功能
                            final SysUserService sysUserService = new SysUserService();
                            //校验的流程
                            final NetMsg result = sysUserService.checkLogin(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }
                        //用户注册
                        else if (type.endsWith("SIGNUP")) {
                            //处理用户注册的功能
                            final SysUserService sysUserService = new SysUserService();
                            //校验的流程
                            final NetMsg result = sysUserService.checkSignUp(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                    }
                    //用户处理图书
                     if (type.startsWith("Book")) {
                        //处理用户查询图书的功能
                        if (type.endsWith("SELECT")) {
                            final SysBookService sysBookService = new SysBookService();
                            //校验的流程
                            final NetMsg<List<SysBook>> result = sysBookService.checkSelectBook(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        //处理用户添加图书的功能
                        else if (type.endsWith("ADD")) {
                            final SysBookService sysBookService = new SysBookService();
                            //校验的流程
                            final NetMsg result = sysBookService.checkAddBook(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        //处理用户删除图书的功能
                        else if (type.endsWith("DELETE")) {
                            final SysBookService sysBookService = new SysBookService();
                            //校验的流程
                            final NetMsg result = sysBookService.checkdelete(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        //处理用户修改图书的功能
                        else if (type.endsWith("MODIFY")) {
                            final SysBookService sysBookService = new SysBookService();
                            //校验的流程
                            final NetMsg result = sysBookService.checkModify(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }
                    }

                    //处理客户
                    if (type.startsWith("CUSTOMER")) {

                        if (type.endsWith("ADD")) {
                            final SysCustomerService sysCustomerService = new SysCustomerService();
                            //校验的流程
                            final NetMsg result = sysCustomerService.checkAddCustomer(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                       else if (type.endsWith("MODIFY")) {
                            final SysCustomerService sysCustomerService = new SysCustomerService();
                            //校验的流程
                            final NetMsg result = sysCustomerService.checkModify(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        else if (type.endsWith("SELECT")) {
                            final SysCustomerService sysCustomerService = new SysCustomerService();
                            //校验的流程
                            final NetMsg result = sysCustomerService.checkSelectCustomer(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        else if (type.endsWith("DELETE")) {
                            final SysCustomerService sysCustomerService = new SysCustomerService();
                            //校验的流程
                            final NetMsg result = sysCustomerService.checkdeleteCustomer(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }
                    }

                    //处理订单
                    if (type.startsWith("ORDER")) {

                        if (type.endsWith("ADD")) {
                            final SysOrderService sysOrderService = new SysOrderService();
                            //校验的流程
                            final NetMsg result = sysOrderService.checkAddOrder(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                       else if (type.endsWith("ADDD")) {
                            final SysOrderService sysOrderService = new SysOrderService();
                            //校验的流程
                            final NetMsg result = sysOrderService.checkAddOrder1(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                       else if (type.endsWith("MODIFY")) {
                            final SysOrderService sysOrderService = new SysOrderService();
                            //校验的流程
                            final NetMsg result = sysOrderService.checkModifyOrder(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                        else if (type.endsWith("SELECT")) {
                            final SysOrderService sysOrderService = new SysOrderService();
                            //校验的流程
                            final NetMsg<List<OrderPub>> result = sysOrderService.checkSelectOrder(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }


                        else if (type.endsWith("DELETE")) {
                            final SysOrderService sysOrderService = new SysOrderService();
                            //校验的流程
                            final NetMsg result = sysOrderService.checkDeleteOrder(request);
                            //将结果发送给客户端
                            oos.writeObject(result);
                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
