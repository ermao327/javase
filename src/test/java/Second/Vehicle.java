package Second;

public class Vehicle {
    private int size;
    private int speed;

    private String run;

    public Vehicle(int speed,int size) {
        this.speed = speed;
        this.size = size;
    }

    public void move(){
//        this.run="冲冲冲";
        System.out.println("冲冲冲");
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void speedUp(int speed){
        this.speed += speed;
    }
    public void speedDown(){
        this.speed -=speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle(90,3);
        vehicle.setSpeed(180);
        System.out.println(vehicle);
        vehicle.speedUp(20);
        System.out.println(vehicle);
        vehicle.speedDown();
        System.out.println(vehicle);
//        vehicle.move();
//        System.out.println(vehicle.run);
        vehicle.move();
    }
}
