package Enum;

public enum Color {
    RED("红色"),GREEN("绿色"),BLUE("蓝色"),YELLOW("黄色");
    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void method(){
    System.out.println("我是个枚举，我的颜色是"+this.name());
}

    public static void main(String[] args) {
        Color color=Color.RED;
        System.out.println(color.name());
        color.method();
    }
}
