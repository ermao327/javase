package ebookstore.entity;

import java.io.Serializable;
import java.util.Date;

public class SysOrder implements Serializable {
    private Integer ORDERNO;
    private Integer CUSTOMER;
    private Date ORSERDATE;
    private Date SHIPDATE;
    private String SHIPSTREET;
    private String SHIPCITY;
    private String SHIPSTATE;
    private String SHIPZIP;

    public SysOrder(Integer ORDERNO, Date SHIPDATE, String SHIPSTREET, String SHIPCITY, String SHIPSTATE, String SHIPZIP) {
        this.ORDERNO = ORDERNO;
        this.SHIPDATE = SHIPDATE;
        this.SHIPSTREET = SHIPSTREET;
        this.SHIPCITY = SHIPCITY;
        this.SHIPSTATE = SHIPSTATE;
        this.SHIPZIP = SHIPZIP;
    }

    @Override
    public String toString() {
        return "SysOrder{" +
                "ORDERNO=" + ORDERNO +
                ", CUSTOMER=" + CUSTOMER +
                ", ORSERDATE=" + ORSERDATE +
                ", SHIPDATE=" + SHIPDATE +
                ", SHIPSTREET='" + SHIPSTREET + '\'' +
                ", SHIPCITY='" + SHIPCITY + '\'' +
                ", SHIPSTATE='" + SHIPSTATE + '\'' +
                ", SHIPZIP='" + SHIPZIP + '\'' +
                '}';
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

    public Date getORSERDATE() {
        return ORSERDATE;
    }

    public void setORSERDATE(Date ORSERDATE) {
        this.ORSERDATE = ORSERDATE;
    }

    public void setSHIPDATE(Date SHIPDATE) {
        this.SHIPDATE = SHIPDATE;
    }

    public void setSHIPSTREET(String SHIPSTREET) {
        this.SHIPSTREET = SHIPSTREET;
    }

    public void setSHIPCITY(String SHIPCITY) {
        this.SHIPCITY = SHIPCITY;
    }

    public void setSHIPSTATE(String SHIPSTATE) {
        this.SHIPSTATE = SHIPSTATE;
    }

    public void setSHIPZIP(String SHIPZIP) {
        this.SHIPZIP = SHIPZIP;
    }

    public SysOrder() {
    }

    public Integer getORDERNO() {
        return ORDERNO;
    }

    public Date getSHIPDATE() {
        return SHIPDATE;
    }

    public String getSHIPSTREET() {
        return SHIPSTREET;
    }

    public String getSHIPCITY() {
        return SHIPCITY;
    }

    public String getSHIPSTATE() {
        return SHIPSTATE;
    }

    public String getSHIPZIP() {
        return SHIPZIP;
    }

    public SysOrder(Integer ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public SysOrder(Integer ORDERNO, Integer CUSTOMER, Date ORSERDATE, Date SHIPDATE, String SHIPSTREET, String SHIPCITY, String SHIPSTATE, String SHIPZIP) {
        this.ORDERNO = ORDERNO;
        this.CUSTOMER = CUSTOMER;
        this.ORSERDATE = ORSERDATE;
        this.SHIPDATE = SHIPDATE;
        this.SHIPSTREET = SHIPSTREET;
        this.SHIPCITY = SHIPCITY;
        this.SHIPSTATE = SHIPSTATE;
        this.SHIPZIP = SHIPZIP;
    }
}
