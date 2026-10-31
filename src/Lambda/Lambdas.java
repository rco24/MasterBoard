package Lambda;

public class Lambdas {
    public static void main(String[] args) {
        Cat myCat = new Cat();

        //printThing(myCat);

        printThing(() -> "Miau!");
    }
    static void printThing(Printable thing){
        //thing.print();
        System.out.println(thing);
        System.out.println(thing.print());
    }
}
