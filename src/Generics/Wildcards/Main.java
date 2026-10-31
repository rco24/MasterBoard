package Generics.Wildcards;

import Generics.BoundedClasses.Animal;
import Generics.BoundedClasses.Cat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(7);
        printList(intList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Figaro", "White", 9));
        catList.add(new Cat());
        printList(catList);

        printListBounded(catList);

    }

    private static void printList(List<?> myList){
        System.out.println(myList);
    }

    private static void printListBounded(List<? extends Animal> myList){
        System.out.println(myList);
    }
}
