package PresidentialElections;

public class Bird {
    public String color;
    public int age;


    private static int birdCounter = 0;
    public Bird(String color, int age){
        this.color = color;
        this.age = age;
        birdCounter = birdCounter + 1;
    }

    public Bird(){
        color = "Undefined";
        age = 0;
        birdCounter = birdCounter + 1;
    }
    public static int getBirdCounter() {
        return birdCounter;
    }
}
