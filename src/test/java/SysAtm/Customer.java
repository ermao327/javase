package SysAtm;

public class Customer {
    private String uname;
    private String upassword;
    private String cardid;
    private String londate;
    private String id;
    private int money;
    private String status;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", cardid='" + cardid + '\'' +
                ", londate='" + londate + '\'' +
                ", id='" + id + '\'' +
                ", money=" + money +
                ", status='" + status + '\'' +
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

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getLondate() {
        return londate;
    }

    public void setLondate(String londate) {
        this.londate = londate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer(String uname, String upassword, String cardid, String londate, String id, int money, String status) {
        this.uname = uname;
        this.upassword = upassword;
        this.cardid = cardid;
        this.londate = londate;
        this.id = id;
        this.money = money;
        this.status =
                status;
    }
}
