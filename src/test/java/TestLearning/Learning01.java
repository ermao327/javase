package TestLearning;

import java.awt.*;
import java.util.Arrays;

public class Learning01 {
    public static void main(String[] args) {
//        Circle circle = new Circle("灰色", 5);
//        Rectangle rectangle = new Rectangle("白色", 5, 6);
        Shape shape = new Shape("白色",5,7);
        System.out.println(shape.toString());
//        circle.showAll();
//        rectangle.showAll();
    }
}
 class Shape{
    private double area;
    private double per;
    private String color;

    public Shape() {
    }

    public Shape(String color,double area,double Per) {
        this.color = color;
        this.area=area;
        this.per=Per;
    }

     @Override
     public String toString() {
         return "Shape{" +
                 "area=" + area +
                 ", per=" + per +
                 ", color='" + color + '\'' +
                 '}';
     }

     public double getPer() {
       return (this.area+this.per)*2;
    }

    public String getColor() {
        return color;
    }

//    abstract public double getArea();
//    abstract public double getPer();
//    abstract public void showAll();
}
//class Rectangle extends Shape{
//    private double width;
//    private double height;
//    public Rectangle() {
//    }
//
//    public Rectangle(String color, double width, double height) {
//        super(color);
//        this.width = width;
//        this.height = height;
//    }
//
//    @Override
//    public double getArea() {
//        return this.height*this.width;
//    }
//
//    @Override
//    public double getPer() {
//        return (this.height+this.width)*2;
//    }
//
//
//    @Override
//    public void showAll() {
//        System.out.println("长方形的颜色为" + this.getColor()+"周长为" + getPer() + "面积为" + getArea());
//    }
//}
//class  Circle extends Shape{
//    final static double PI=3.14125;
//    private double radius;
//
//    public Circle() {
//    }
//
//    public Circle(String color, double radius) {
//        super(color);
//        this.radius = radius;
//    }
//
//    @Override
//    public double getArea() {
//        return PI*radius*radius;
//    }
//
//    @Override
//    public double getPer() {
//        return PI*radius*2;
//    }
//
//    @Override
//    public void showAll() {
//        System.out.println("圆的颜色为" + this.getColor()+"周长为" + getPer() + "面积为" + getArea());
//    }
//}