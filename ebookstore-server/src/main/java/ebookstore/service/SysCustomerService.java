package ebookstore.service;

import ebookstore.dao.SysCustomerDao;
import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.entity.SysCustomer;
import ebookstore.net.NetMsg;

import java.util.List;

public class SysCustomerService {
    private SysCustomerDao sysCustomerDao = new SysCustomerDao();

    //查询
    public NetMsg<List<SysCustomer>> checkSelectCustomer(NetMsg<SysCustomer> request) throws Exception {
        final List<SysCustomer> list = sysCustomerDao.select(request.getData());
        return new NetMsg<>(list,"SUCCESS");

    }

    //删除
    public NetMsg<String> checkdeleteCustomer(NetMsg<SysCustomer> request) throws Exception{
        final SysCustomer byCustomer = sysCustomerDao.selectByCustomer(request.getData().getCUSTOMER());
        if(null!=byCustomer){
            final SysCustomer sysCustomer = sysCustomerDao.deleteOne(request.getData());
            if (null != sysCustomer) {
                return new NetMsg<>("删除成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("客户不存在", "CUSTOMER_ERROR");
        }
        return null;
    }


    //添加
    public NetMsg<String> checkAddCustomer(NetMsg<SysCustomer> request) throws Exception{
        final SysCustomer byCustomer = sysCustomerDao.selectByCustomer(request.getData().getCUSTOMER());
        if(null!=byCustomer){
            return new NetMsg<>("客户已存在", "CUSTOMER_DUP");
        }
        else {
            final SysCustomer sysCustomer = sysCustomerDao.addOne(request.getData());
            if (null != sysCustomer) {
                return new NetMsg<>("添加成功", "SUCCESS");
            }
            return null;
        }
    }

    //修改
    public NetMsg<String> checkModify(NetMsg<SysCustomer> request) throws Exception{
        final SysCustomer byCustomer = sysCustomerDao.selectByCustomer(request.getData().getCUSTOMER());
        if(null!=byCustomer){
            final SysCustomer sysCustomer = sysCustomerDao.modifyOne(request.getData());
            if (null != sysCustomer) {
                return new NetMsg<>("修改成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("客户不存在", "CUSTOMER_ERROR");
        }
        return null;
    }
}
