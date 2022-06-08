package ebookstore.entity;

import java.io.Serializable;
import java.util.Date;

public class SysBook implements Serializable {
    private String ISBN;
    private String TITLE;
    private Date PUBDATE;
    private Integer PUBID;
    private double COST;
    private double RETAIL;
    private String CATEGORY;

    @Override
    public String toString() {
        return "SysBook{" +
                "ISBN='" + ISBN + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", PUBDATE=" + PUBDATE +
                ", PUBID=" + PUBID +
                ", COST=" + COST +
                ", RETAIL=" + RETAIL +
                ", CATEGORY='" + CATEGORY + '\'' +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public Date getPUBDATE() {
        return PUBDATE;
    }

    public void setPUBDATE(Date PUBDATE) {
        this.PUBDATE = PUBDATE;
    }

    public Integer getPUBID() {
        return PUBID;
    }

    public void setPUBID(Integer PUBID) {
        this.PUBID = PUBID;
    }

    public double getCOST() {
        return COST;
    }

    public void setCOST(double COST) {
        this.COST = COST;
    }

    public double getRETAIL() {
        return RETAIL;
    }

    public void setRETAIL(double RETAIL) {
        this.RETAIL = RETAIL;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public SysBook() {
    }

    public SysBook(String ISBN) {
        this.ISBN = ISBN;
    }

    public SysBook(String TITLE, Date PUBDATE, Integer PUBID, double COST, double RETAIL, String CATEGORY) {
        this.TITLE = TITLE;
        this.PUBDATE = PUBDATE;
        this.PUBID = PUBID;
        this.COST = COST;
        this.RETAIL = RETAIL;
        this.CATEGORY = CATEGORY;
    }

    public SysBook(String ISBN, String TITLE, Date PUBDATE, Integer PUBID, double COST, double RETAIL, String CATEGORY) {
        this.ISBN = ISBN;
        this.TITLE = TITLE;
        this.PUBDATE = PUBDATE;
        this.PUBID = PUBID;
        this.COST = COST;
        this.RETAIL = RETAIL;
        this.CATEGORY = CATEGORY;
    }
}
