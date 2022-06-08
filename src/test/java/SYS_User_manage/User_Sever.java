package SYS_User_manage;

import stu_system.Student;

public class User_Sever {
    private User[] users = new User[3];
    public User_Sever() {
        users[0]=new User("abc", "123","454546@qq.com","普通用户");
        users[1]=new User("asd", "123","454546@qq.com","普通用户");
        users[2]=new User("qwe", "123","454546@qq.com","普通用户");
    }
    public boolean DecideInputUname(String uname,String upassword){
        boolean flag=false;
        for (int i = 0; i <users.length; i++) {
            if(uname.equals(users[i].getUname())&&upassword.equals(users[i].getUpassword()))
            {
                 flag=true;
                 return flag;
            }
        }
        return false;

    }
    public User[] users(){
        return this.users;
    }

}
