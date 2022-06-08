package inner;

import javax.swing.*;
import java.io.Serializable;
import java.util.Arrays;

public class aodi implements Serializable {
    public static void main(String[] args) {
        final aodi aodi1 = new aodi("奥迪", "A6", "白色", "米其林", 60);
        System.out.println(aodi1);
        aodi1.run();
    }
    private String band;
    private String type;
    private String color;
    private Wheel[] wheels;
    private int speed;

    @Override
    public String toString() {
        return "aodi{" +
                "band='" + band + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", wheels=" + Arrays.toString(wheels) +
                ", speed=" + speed +
                '}';
    }

    public aodi(String band, String type, String color, String wheelBand, int wheelDiameter) {
        this.band = band;
        this.type = type;
        this.color = color;
        this.wheels = new Wheel[4];
        for (int i = 0; i < this.wheels.length; i++) {
            this.wheels[i]=new Wheel(wheelBand, wheelDiameter);
        }
        this.speed = this.wheels[0].diameter*5;
    }

    public void run(){
        for (Wheel wheel : this.wheels) {
            wheel.roll();
        }
    }

    private class Wheel implements Serializable{
        private String band;
        private int diameter;

        public Wheel(String band, int diameter) {
            this.band = band;
            this.diameter = diameter;
        }
        public void roll(){
            System.out.println("滋啦滋啦");
        }

        @Override
        public String toString() {
            return "wheel{" +
                    "band='" + band + '\'' +
                    ", diameter='" + diameter + '\'' +
                    '}';
        }
    }



}
