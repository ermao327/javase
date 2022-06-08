package ebookstore.entity;

import java.io.Serializable;

public class SysCustomer implements Serializable {
    private Integer CUSTOMER;
    private String CUSTOMER_NAME;
    private String CITY;
    private String STATE;
    private String ZIP;
    private Integer REFERRED;
    private String TEL_NO;
    private String ADDRESS;

    @Override
    public String toString() {
        return "SysCustomer{" +
                "CUSTOMER=" + CUSTOMER +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                ", CITY='" + CITY + '\'' +
                ", STATE='" + STATE + '\'' +
                ", ZIP='" + ZIP + '\'' +
                ", REFERRED=" + REFERRED +
                ", TEL_NO='" + TEL_NO + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                '}';
    }

    public SysCustomer(Integer CUSTOMER) {
        this.CUSTOMER = CUSTOMER;
    }

    public SysCustomer() {
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

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public Integer getREFERRED() {
        return REFERRED;
    }

    public void setREFERRED(Integer REFERRED) {
        this.REFERRED = REFERRED;
    }

    public String getTEL_NO() {
        return TEL_NO;
    }

    public void setTEL_NO(String TEL_NO) {
        this.TEL_NO = TEL_NO;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public SysCustomer(Integer CUSTOMER, String CUSTOMER_NAME, String CITY, String STATE, String ZIP, Integer REFERRED, String TEL_NO, String ADDRESS) {
        this.CUSTOMER = CUSTOMER;
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.CITY = CITY;
        this.STATE = STATE;
        this.ZIP = ZIP;
        this.REFERRED = REFERRED;
        this.TEL_NO = TEL_NO;
        this.ADDRESS = ADDRESS;
    }
}