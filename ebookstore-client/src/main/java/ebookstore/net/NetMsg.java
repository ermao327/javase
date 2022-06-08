package ebookstore.net;

import java.io.Serializable;

/**
 * 网络消息对象
 * @param <T>
 */
public class NetMsg<T> implements Serializable {

    private T data;

    private String type;

    @Override
    public String toString() {
        return "NetMsg{" +
                "data=" + data +
                ", type='" + type + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NetMsg() {
    }

    public NetMsg(T data, String type) {
        this.data = data;
        this.type = type;
    }
}
