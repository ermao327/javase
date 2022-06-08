package ebookstore.entity;

import java.io.Serializable;

public class SysOrderItems implements Serializable {
    private Integer ORDERNO;
    private Integer ITEM;
    private String ISBN;
    private Integer QUANTITY;

    @Override
    public String toString() {
        return "SysOrderItems{" +
                "ORDERNO=" + ORDERNO +
                ", ITEM=" + ITEM +
                ", ISBN='" + ISBN + '\'' +
                ", QUANTITY=" + QUANTITY +
                '}';
    }

    public Integer getORDERNO() {
        return ORDERNO;
    }

    public void setORDERNO(Integer ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public Integer getITEM() {
        return ITEM;
    }

    public void setITEM(Integer ITEM) {
        this.ITEM = ITEM;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Integer QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public SysOrderItems() {
    }

    public SysOrderItems(Integer ORDERNO, Integer ITEM, String ISBN, Integer QUANTITY) {
        this.ORDERNO = ORDERNO;
        this.ITEM = ITEM;
        this.ISBN = ISBN;
        this.QUANTITY = QUANTITY;
    }
}
