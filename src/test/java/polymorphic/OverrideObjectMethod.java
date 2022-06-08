package polymorphic;

public class OverrideObjectMethod {
    public static void main(String[] args) {
    }
}

class Person1 {
    String name="张三";
    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person1:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person1类型:
        if (o instanceof Person1) {
            Person1 p = (Person1) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}