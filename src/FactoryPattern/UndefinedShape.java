package FactoryPattern;

public class UndefinedShape extends Shape implements I_Shape {

    public UndefinedShape(String shape){
        super.name = shape;
    }
    @Override
    public void draw(){
        System.out.println("Undefined shape \"" + name + "\". CANNOT DRAW!");
    }

    @Override
    public float calculateArea() {
        System.out.println("Unable to calculate the area of this figure. Undefined shape!");
        return 0;
    }


}
