package ebookstore.service;

import ebookstore.dao.SysUserDao;
import ebookstore.entity.SysBook;
import ebookstore.entity.SysUser;
import ebookstore.net.NetMsg;

import java.util.List;

/**
 * 值负责逻辑处理，负责数据的加工
 */
public class SysUserService {

    private SysUserDao sysUserDao = new SysUserDao();

    //登录模块
    public NetMsg<String> checkLogin(NetMsg<SysUser> request) throws Exception {//登录
        final SysUser sysUser = sysUserDao.selectByUsername(request.getData().getUsername());
        //判断的是用户名
        if (null == sysUser) {
            return new NetMsg<>("用户名不存在", "USERNAME_ERROR");
        } else {
            //判断密码
            final SysUser sysUser1 = sysUserDao.selectByUsernameAndPassword(request.getData());
            if (null == sysUser1) {
                return new NetMsg<>("密码不正确", "PASSWORD_ERROR");
            } else {
                return new NetMsg<>("登陆成功", "SUCCESS");
            }
        }
    }

    public NetMsg<String> checkSignUp(NetMsg<SysUser> request) throws Exception {//注册
        final SysUser sysUser = sysUserDao.selectByUsername(request.getData().getUsername());
        //判断用户重名
        if (null != sysUser) {
            return new NetMsg<>("用户名已存在", "USERNAME_DUP");
        } else {
            final SysUser sysUser1 = sysUserDao.addOne(request.getData());
            if (null != sysUser1) {
                return new NetMsg<>("注册成功", "SUCCESS");
            }
            return null;
        }
    }


}


