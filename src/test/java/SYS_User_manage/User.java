package SYS_User_manage;

public class User {
    private String uname;
    private String upassword;
    private String uemail;
    private String upower;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uemail='" + uemail + '\'' +
                ", upower='" + upower + '\'' +
                '}';
    }

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

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpower() {
        return upower;
    }

    public void setUpower(String upower) {
        this.upower = upower;
    }

    public User(String uname, String upassword, String uemail, String upower) {
        this.uname = uname;
        this.upassword = upassword;
        this.uemail = uemail;
        this.upower = upower;
    }
}
