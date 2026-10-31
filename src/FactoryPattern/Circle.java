package FactoryPattern;

public class Circle extends Shape implements I_Shape {
    public int radio;

    public Circle(){
        radio = 1;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a circle..");
    }

    @Override
    public float calculateArea() {
        System.out.println("Calculating the area of the circle..");
        return 0;
    }
}
