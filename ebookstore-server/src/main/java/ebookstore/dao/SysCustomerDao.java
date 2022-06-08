package ebookstore.dao;

import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.entity.SysCustomer;
import ebookstore.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class SysCustomerDao {
    private JDBCUtil jdbcUtil = new JDBCUtil();

    //查询
    public List<SysCustomer> select(SysCustomer condition) throws Exception {
        String select = "select * from tbl_customer where 1=1 ";
        List<Object> conditionlist=new ArrayList<>();
        if(condition.getCUSTOMER()!=null){
            select += "and CUSTOMER = ?";
            conditionlist.add(condition.getCUSTOMER());
        }
        if(condition.getCUSTOMER_NAME()!=null){
            select += "and CUSTOMER_NAME like ?";
            conditionlist.add("%"+condition.getCUSTOMER_NAME()+"%");
        }
        System.out.println("select="+select);
        System.out.println(conditionlist);
        return jdbcUtil.queryMany(select, SysCustomer.class,conditionlist.toArray());
    }

    //删除模块
    public SysCustomer deleteOne(SysCustomer sysCustomer) throws Exception {//按编号删除
        jdbcUtil.update("delete from tbl_customer where CUSTOMER=?", sysCustomer.getCUSTOMER());
        return sysCustomer;
    }

    //添加模块
    public SysCustomer addOne(SysCustomer sysCustomer) throws Exception {//添加图书
        jdbcUtil.update("insert into tbl_customer values(?,?,?,?,?,?,?,?)",
                sysCustomer.getCUSTOMER(),sysCustomer.getCUSTOMER_NAME(),sysCustomer.getCITY(),
                sysCustomer.getSTATE(),sysCustomer.getZIP(),sysCustomer.getREFERRED(),
                sysCustomer.getTEL_NO(),sysCustomer.getADDRESS());
        return sysCustomer;
    }
    public SysCustomer modifyOne(SysCustomer sysCustomer) throws Exception{
        String sql = " UPDATE  `tbl_customer` " +
                "SET `CUSTOMER_NAME`=?,`CITY` = ?," +
                "`STATE`=?,`ZIP`=?,`REFERRED`=?,`TEL_NO`=?," +
                "`ADDRESS`=?" +
                "WHERE `CUSTOMER` = ?";
        jdbcUtil.update(sql,sysCustomer.getCUSTOMER_NAME(),sysCustomer.getCITY(),sysCustomer.getSTATE(),
                sysCustomer.getZIP(),sysCustomer.getREFERRED(),sysCustomer.getTEL_NO(),sysCustomer.getADDRESS(),
                sysCustomer.getCUSTOMER());
        return sysCustomer;
    }

    //可复用，按编号查询
    public SysCustomer selectByCustomer(Integer CUSTOMER) throws Exception {//添加时按编号查询是否已经存在此图书
        return jdbcUtil.queryOne("select * from tbl_customer where CUSTOMER=?",
                SysCustomer.class, CUSTOMER);
    }
}
