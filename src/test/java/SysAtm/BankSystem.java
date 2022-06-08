package SysAtm;

public class BankSystem {
    private String uname;
    private String upassword;

    public BankSystem() {
    }

    public BankSystem(String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "BankSystem{" +
                "uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
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
}
