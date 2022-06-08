package ebookstore.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderPub implements Serializable {
    private Integer ORDERNO;
    private Integer CUSTOMER;
    private String CUSTOMER_NAME;
    private Date ORSERDATE;
    private Date SHIPDATE;
    private String SHIPSTREET;
    private String SHIPCITY;
    private String SHIPSTATE;
    private String SHIPZIP;
    private String TITLE;

    @Override
    public String toString() {
        return "OrderPub{" +
                "ORDERNO=" + ORDERNO +
                ", CUSTOMER=" + CUSTOMER +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                ", ORSERDATE=" + ORSERDATE +
                ", SHIPDATE=" + SHIPDATE +
                ", SHIPSTREET='" + SHIPSTREET + '\'' +
                ", SHIPCITY='" + SHIPCITY + '\'' +
                ", SHIPSTATE='" + SHIPSTATE + '\'' +
                ", SHIPZIP='" + SHIPZIP + '\'' +
                ", TITLE='" + TITLE + '\'' +
                '}';
    }

    public OrderPub() {
    }

    public Integer getORDERNO() {
        return ORDERNO;
    }

    public void setORDERNO(Integer ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public Integer getCUSTOMER() {
        return CUSTOMER;
    }

    public void setCUSTOMER(Integer CUSTOMER) {
        this.CUSTOMER = CUSTOMER;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public Date getORSERDATE() {
        return ORSERDATE;
    }

    public void setORSERDATE(Date ORSERDATE) {
        this.ORSERDATE = ORSERDATE;
    }

    public Date getSHIPDATE() {
        return SHIPDATE;
    }

    public void setSHIPDATE(Date SHIPDATE) {
        this.SHIPDATE = SHIPDATE;
    }

    public String getSHIPSTREET() {
        return SHIPSTREET;
    }

    public void setSHIPSTREET(String SHIPSTREET) {
        this.SHIPSTREET = SHIPSTREET;
    }

    public String getSHIPCITY() {
        return SHIPCITY;
    }

    public void setSHIPCITY(String SHIPCITY) {
        this.SHIPCITY = SHIPCITY;
    }

    public String getSHIPSTATE() {
        return SHIPSTATE;
    }

    public void setSHIPSTATE(String SHIPSTATE) {
        this.SHIPSTATE = SHIPSTATE;
    }

    public String getSHIPZIP() {
        return SHIPZIP;
    }

    public void setSHIPZIP(String SHIPZIP) {
        this.SHIPZIP = SHIPZIP;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public OrderPub(Integer ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public OrderPub(Integer ORDERNO, Integer CUSTOMER, String CUSTOMER_NAME, Date ORSERDATE, Date SHIPDATE, String SHIPSTREET, String SHIPCITY, String SHIPSTATE, String SHIPZIP, String TITLE) {
        this.ORDERNO = ORDERNO;
        this.CUSTOMER = CUSTOMER;
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.ORSERDATE = ORSERDATE;
        this.SHIPDATE = SHIPDATE;
        this.SHIPSTREET = SHIPSTREET;
        this.SHIPCITY = SHIPCITY;
        this.SHIPSTATE = SHIPSTATE;
        this.SHIPZIP = SHIPZIP;
        this.TITLE = TITLE;
    }
}
