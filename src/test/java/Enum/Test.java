package Enum;

public class Test {
    public static void main(String[] args) {
        Color color=Color.BLUE;
        switch (color){
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
        }
    }
}
