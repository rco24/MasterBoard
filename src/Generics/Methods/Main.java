package Generics.Methods;

import Generics.BoundedClasses.Cat;

public class Main {
    public static void main(String[] args){

        shout("John");
        shout(57);
        shout(new Cat("Minino","White", 9, 1)); //This is using the class Cat from the package BoundedClasses

        shoutWithTwoParams("John", 74);
        System.out.println("_______________________________________________");
        System.out.println(shoutWithTwoParams("pepito", "another"));

    }
    private static <T> void shout(T thingToShout){
        //method that does not return anything
        System.out.println(thingToShout + "!!!");
    }
    private static <T, V> T shoutWithTwoParams(T thingToShout, V otherThingToShout){
        //method that returns a generic parameter
        System.out.println(thingToShout + "!!!");
        System.out.println(otherThingToShout + "!!!");
        return thingToShout;
    }
}
