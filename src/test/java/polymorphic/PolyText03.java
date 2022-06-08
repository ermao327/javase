package polymorphic;

public class PolyText03 {
    public static void main(String[] args) {
        car c=new car(4, "红色", 100, 80, "aaa", "bbb" );
        System.out.println(c);
        c.speedup();
        System.out.println(c);
    }
}
class carnature{
    private int wheels;

    private String color;

    private int weight;

    private int speed;

    public carnature(int wheels, String color, int weight, int speed) {
        this.wheels = wheels;
        this.color = color;
        this.weight = weight;
        this.speed = speed;
    }

    public void speedup(){
        this.speed++;
    }
    public void speeddown(){
        this.speed--;
    }
    public void stop(){
        this.speed=0;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

class car extends carnature{
    private String airCondition;

    private String cd;

    public car(int wheels, String color, int weight, int speed, String airCondition, String cd) {
        super(wheels, color, weight, speed);
        this.airCondition = airCondition;
        this.cd = cd;
    }

    @Override
    public void speedup() {
       this.setSpeed(this.getSpeed()+2);
    }

    @Override
    public void speeddown() {
        this.setSpeed(this.getSpeed()-2);
    }

    @Override
    public String toString() {
        return "Car{" +
                "airCondition='" + airCondition + '\'' +
                ", cd='" + cd + '\'' +
                ",wheels="+this.getWheels() +
                ",color=" + this.getColor() +
                ",weight=" + this.getWeight() +
                ",speed=" + this.getSpeed() +
                '}';
    }
}