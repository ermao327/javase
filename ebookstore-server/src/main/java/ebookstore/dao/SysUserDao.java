package ebookstore.dao;
import ebookstore.entity.SysBook;
import ebookstore.entity.SysUser;
import ebookstore.util.JDBCUtil;

import java.util.List;

/**
 *
 * 用来获取数据或者持久化数据
 */
public class SysUserDao {

    private JDBCUtil jdbcUtil = new JDBCUtil();

//账号模块
    public SysUser addOne(SysUser sysUser) throws Exception {//添加账号
          jdbcUtil.update("insert into tbl_sysuser values(?,?,?)",
                   sysUser.getId(),sysUser.getUsername(),sysUser.getPassword());
          return sysUser;
    }

    public SysUser selectByUsername(String username) throws Exception {//登录时候查询是否存在|注册时查询是否重名
        return jdbcUtil.queryOne("select * from tbl_sysuser where username=?",
                SysUser.class, username);
    }

    public SysUser selectByUsernameAndPassword(SysUser sysUser) throws Exception {//登录时候查询密码
        return jdbcUtil.queryOne("select * from tbl_sysuser where username=? and password=?",
                SysUser.class, sysUser.getUsername(),sysUser.getPassword());
    }


}
