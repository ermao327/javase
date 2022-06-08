package ebookstore.dao;

import ebookstore.entity.*;
import ebookstore.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class SysOrderDao {
    private JDBCUtil jdbcUtil = new JDBCUtil();
    //删除模块
    public SysOrder deleteOne(SysOrder sysOrder) throws Exception {//按图书编号删除
        jdbcUtil.update("delete from tbl_orders where orderno=?", sysOrder.getORDERNO());
        return sysOrder;
    }
    //查询
    public List<OrderPub> select(OrderPub condition) throws Exception {
        String select = "SELECT o.*,c.CUSTOMER_NAME CUSTOMER_NAME,b.title TITLE from tbl_orders o " +
                "join tbl_customer c on o.CUSTOMER=c.CUSTOMER\n"+
                "join tbl_orderitems i on o.ORDERNO=i.ORDERNO\n" +
                "join tbl_books b on i.ISBN=b.ISBN where 1=1 ";
        List<Object> conditionlist=new ArrayList<>();
        if(condition.getORDERNO()!=null){
            select += "and o.orderno = ?";
            conditionlist.add(condition.getORDERNO());
        }
        if(condition.getCUSTOMER_NAME()!=null){
            select += "and c.CUSTOMER_NAME like ?";
            conditionlist.add("%"+condition.getCUSTOMER_NAME()+"%");
        }
        System.out.println("select="+select);
        System.out.println(conditionlist);
        return jdbcUtil.queryMany(select, OrderPub.class,conditionlist.toArray());
    }



    //添加模块
    public SysOrder addOne(SysOrder sysOrder) throws Exception {//下单
        String sql="insert into tbl_orders values(?,?,?,?,?,?,?,?)";
        jdbcUtil.update(sql,
                sysOrder.getORDERNO(),sysOrder.getCUSTOMER(),sysOrder.getORSERDATE(),sysOrder.getSHIPDATE(),
                sysOrder.getSHIPSTREET(),sysOrder.getSHIPCITY(),sysOrder.getSHIPSTATE(),sysOrder.getSHIPZIP());
        System.out.println(sql);
        return sysOrder;
    }

    //添加模块
    public SysOrderItems addTwo(SysOrderItems sysOrderItems) throws Exception {//下单
        String sql="insert into tbl_orderitems values(?,?,?,?)";
        jdbcUtil.update(sql,
                sysOrderItems.getORDERNO(),sysOrderItems.getITEM(),sysOrderItems.getISBN(),sysOrderItems.getQUANTITY());
        System.out.println(sql);
        return sysOrderItems;
    }

    public SysOrder selectByOrderno(Integer orderno) throws Exception {
        return jdbcUtil.queryOne("select * from tbl_orders where orderno=?",
                SysOrder.class, orderno);
    }

    //修改模块
    public SysOrder modifyOne(SysOrder sysOrder) throws Exception{
        String sql = " UPDATE  `tbl_orders` SET `SHIPDATE`= ?,`SHIPSTREET` = ?,`SHIPCITY`=?,`SHIPSTATE`=?,`SHIPZIP`=?  WHERE `orderno` = ?";
        jdbcUtil.update(sql,sysOrder.getSHIPDATE(),sysOrder.getSHIPSTREET(),sysOrder.getSHIPCITY(),
                sysOrder.getSHIPSTATE(),sysOrder.getSHIPZIP(),sysOrder.getORDERNO());
        return sysOrder;
    }

}
