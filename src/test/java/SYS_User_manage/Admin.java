package SYS_User_manage;

public class Admin {
    private String uname;
    private String upassword;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Admin(String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
    }
}
