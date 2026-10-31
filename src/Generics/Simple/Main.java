package Generics.Simple;

public class Main {
    public static void main(String[] args){
        Printer printer = new Printer(23);
        Printer<Integer> printer2 = new Printer<>(1);

        printer.print();
        printer2.print();
    }
}
