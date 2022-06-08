package OopTest;

public class CircleOfArea {
    final static double PI=3.14125;

    public static void main(String[] args) {
        double radius=3.0;
        double area= CircleOfArea.PI*radius*radius;
        double valume=4/3* CircleOfArea.PI*radius*radius*radius;
        Cir yuan=new Cir(radius,area);
        sper qiu=new sper(radius,valume);
    }
}
class Cir {
    double radius;
    double area;
    public  Cir(double radius,double area){
        this.radius=radius;
        this.area=area;
        System.out.println("圆的半径"+this.radius+"圆的面积"+this.area);
    }
}
class sper {
    double radius;
    double valume;
    public  sper(double radius,double valume){
        this.radius=radius;
        this.valume=valume;
        System.out.println("球的半径"+this.radius+"求的面积"+this.valume);
    }
}