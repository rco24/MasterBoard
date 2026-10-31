package Generics.BoundedClasses;

public class Animal {
    private int age;

    public Animal(int age){
        this.age = age;
    }
    public Animal(){
        age = 0;
    }


    public int getAge(){ return age;}
    public void makeNoise(){
        System.out.println("Making noise while moving....");
    }
    public void printAnimalInfo(){
        if (age == 0){
            System.out.println("We don't know the age of this animal.");
        } else {
            System.out.println("We only know that the age of this animal is " + age);

        }
    }
}
