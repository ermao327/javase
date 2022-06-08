package ebookstore.service;

import ebookstore.dao.SysBookDao;
import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.net.NetMsg;

import java.util.List;

public class SysBookService {
    private SysBookDao sysBookDao = new SysBookDao();

    //图书模块
    //查询
    public NetMsg<List<BookPub>> checkSelectBook(NetMsg<SysBook> request) throws Exception {
        final List<BookPub> list = sysBookDao.select(request.getData());
            return new NetMsg<>(list,"SUCCESS");

    }



    //删除
    public NetMsg<String> checkdelete(NetMsg<SysBook> request) throws Exception{
        final SysBook byIsbn = sysBookDao.selectByIsbn(request.getData().getISBN());
        if(null!=byIsbn){
            final SysBook sysBook = sysBookDao.deleteOne(request.getData());
            if (null != sysBook) {
                return new NetMsg<>("删除成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("图书不存在", "BOOK_ERROR");
        }
        return null;
    }
    //修改
    public NetMsg<String> checkModify(NetMsg<SysBook> request) throws Exception{
        final SysBook byIsbn = sysBookDao.selectByIsbn(request.getData().getISBN());
        if(null!=byIsbn){
            final SysBook sysBook = sysBookDao.modifyOne(request.getData());
            if (null != sysBook) {
                return new NetMsg<>("修改成功", "SUCCESS");
            }
        }
        else {
            return new NetMsg<>("图书不存在", "BOOK_ERROR");
        }
        return null;
    }
    //添加
    public NetMsg<String> checkAddBook(NetMsg<SysBook> request) throws Exception{
        final SysBook byIsbn = sysBookDao.selectByIsbn(request.getData().getISBN());
        if(null!=byIsbn){
            return new NetMsg<>("图书已存在", "BOOK_DUP");
        }
        else {
            final SysBook sysBook = sysBookDao.addOne(request.getData());
            if (null != sysBook) {
                return new NetMsg<>("添加成功", "SUCCESS");
            }
            return null;
        }
    }

}
