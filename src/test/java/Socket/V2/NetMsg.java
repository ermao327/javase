package Socket.V2;

import java.io.Serializable;

public class NetMsg implements Serializable {
    private String from;//发送者的名称

    private String to;//接收者的名称

    private String data;

    @Override
    public String toString() {
        return "NetMsg{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NetMsg(String from, String to, String data) {
        this.from = from;
        this.to = to;
        this.data = data;
    }
}
