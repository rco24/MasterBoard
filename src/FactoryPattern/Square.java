package FactoryPattern;

public class Square extends Shape implements I_Shape{
    int side;
    public Square (int side){
        name = "Square";
        this.side = side;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a " + name);
    }

    @Override
    public float calculateArea() {
        System.out.println("Calculating the area of the " + name);
        return side * side;
    }
}
