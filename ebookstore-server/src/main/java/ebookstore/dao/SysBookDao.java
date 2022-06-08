package ebookstore.dao;

import ebookstore.entity.BookPub;
import ebookstore.entity.SysBook;
import ebookstore.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SysBookDao {
    private JDBCUtil jdbcUtil = new JDBCUtil();
    //修改模块
    public SysBook modifyOne(SysBook sysBook) throws Exception{
        String sql = " UPDATE  `tbl_books` " +
                "SET `title`=?,`pubdate` = ?," +
                "`pubid`=?,`cost`=?,`retail`=?," +
                "`CATEGORY`=?" +
                "WHERE `isbn` = ?";
        jdbcUtil.update(sql,sysBook.getTITLE(),sysBook.getPUBDATE(),sysBook.getPUBID(),
                sysBook.getCOST(),sysBook.getRETAIL(),sysBook.getCATEGORY(),sysBook.getISBN());
        return sysBook;
    }
//添加模块
    public SysBook addOne(SysBook sysBook) throws Exception {//添加图书
        jdbcUtil.update("insert into tbl_books values(?,?,?,?,?,?,?)",
                sysBook.getISBN(),sysBook.getTITLE(),sysBook.getPUBDATE(),
                sysBook.getPUBID(),sysBook.getCOST(),sysBook.getRETAIL(),
                sysBook.getCATEGORY());
        return sysBook;
    }
//可复用，按编号查询
    public SysBook selectByIsbn(String isbn) throws Exception {//添加时按编号查询是否已经存在此图书
        return jdbcUtil.queryOne("select * from tbl_books where isbn=?",
                SysBook.class, isbn);
    }

    //删除模块
    public SysBook deleteOne(SysBook sysBook) throws Exception {//按图书编号删除
        jdbcUtil.update("delete from tbl_books where isbn=?", sysBook.getISBN());
        return sysBook;
    }
//可复用，按图书名查询
    public SysBook selectByTitle(String title) throws Exception {//删除;修改时按图书名查询是否已经存在此图书
        return jdbcUtil.queryOne("select * from tbl_books where title=?",
                SysBook.class, title);
    }

    //查询
    public List<BookPub> select(SysBook condition) throws Exception {
        String select = "select b.*,p.name pubname from tbl_books b " +
                "left join tbl_publisher p on b.pubid = p.pubid where 1=1 ";
        List<Object>conditionlist=new ArrayList<>();
        if(condition.getISBN()!=null){
            select += "and isbn = ?";
            conditionlist.add(condition.getISBN());
        }
        if(condition.getTITLE()!=null){
            select += "and title like ?";
            conditionlist.add("%"+condition.getTITLE()+"%");
        }
        if(condition.getCATEGORY()!=null){
            select += "and category like ?";
            conditionlist.add("%"+condition.getCATEGORY()+"%");
        }
        System.out.println("select="+select);
        System.out.println(conditionlist);
       return jdbcUtil.queryMany(select, BookPub.class,conditionlist.toArray());
    }
}
