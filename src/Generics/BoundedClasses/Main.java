package Generics.BoundedClasses;

public class Main {
    public static void main(String[] args){
        GenericPrinter<Cat> catPrinter = new GenericPrinter<>(new Cat("Figaro", "Black", 9));
        GenericPrinter<Dog> dogPrinter = new GenericPrinter<>(new Dog("Firulais", "Yellow", 2));

        catPrinter.print();
        dogPrinter.print();
        System.out.println("the End.");

    }
}
