package FactoryPattern;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args){
        var factory = new ShapeFactory();

        ArrayList<I_Shape> figuras = new ArrayList<>();

        figuras.add(factory.getShape("Bla bla bla"));
        figuras.add(factory.getShape("Circle"));
        figuras.add(factory.getShape("Square"));
        figuras.add(factory.getShape("Triangle"));

        for (I_Shape figura: figuras){
            figura.draw();
            figura.calculateArea();
            System.out.println();
        }


    }
}
