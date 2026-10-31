package Generics.BoundedClasses;

public class GenericPrinter<T extends Animal>{
    private T thingToPrint;
    public GenericPrinter(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        thingToPrint.makeNoise();
        thingToPrint.printAnimalInfo();
        System.out.println();
    }
}
