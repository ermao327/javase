package ebookstore.service;

import ebookstore.dao.SysOrderDao;
import ebookstore.entity.*;
import ebookstore.net.NetMsg;

import java.util.List;

public class SysOrderService {
    private SysOrderDao sysOrderDao=new SysOrderDao();
    //删除
    public NetMsg<String> checkDeleteOrder(NetMsg<SysOrder> request) throws Exception{
        final SysOrder byOrderno = sysOrderDao.selectByOrderno(request.getData().getORDERNO());
        if(null!=byOrderno){
            final SysOrder sysOrder = sysOrderDao.deleteOne(request.getData());
            if (null != sysOrder) {
                return new NetMsg<>("删除成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("订单不存在", "ORDER_ERROR");
        }
        return null;
    }
    //查询
    public NetMsg<List<OrderPub>> checkSelectOrder(NetMsg<OrderPub> request) throws Exception {
        final List<OrderPub> list = sysOrderDao.select(request.getData());
        return new NetMsg<>(list,"SUCCESS");

    }


    //添加1
    public NetMsg<String> checkAddOrder(NetMsg<SysOrder> request) throws Exception{
        final SysOrder byOrderno = sysOrderDao.selectByOrderno(request.getData().getORDERNO());
        if(null!=byOrderno){
            return new NetMsg<>("订单号已存在", "ORDER_DUP");
        }
        else {
            final SysOrder sysOrder = sysOrderDao.addOne(request.getData());
            if (null != sysOrder) {
                return new NetMsg<>("添加成功", "SUCCESS");
            }
            return null;
        }
    }

    //添加2
    public NetMsg<String> checkAddOrder1(NetMsg<SysOrderItems> request) throws Exception{
        final SysOrderItems sysOrderItems = sysOrderDao.addTwo(request.getData());
        return null;

    }

    //修改
    public NetMsg<String> checkModifyOrder(NetMsg<SysOrder> request) throws Exception{
        final SysOrder byOrderno = sysOrderDao.selectByOrderno(request.getData().getORDERNO());
        if(null!=byOrderno){
            final SysOrder sysOrder = sysOrderDao.modifyOne(request.getData());
            if (null != sysOrder) {
                return new NetMsg<>("修改成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("图书不存在", "BOOK_ERROR");
        }
        return null;
    }
}
