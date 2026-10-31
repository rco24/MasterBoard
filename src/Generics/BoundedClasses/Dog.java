package Generics.BoundedClasses;

public class Dog extends Animal{

    private String name;
    private String color;


    public Dog(String name, String color){
        super();
        this.name = name;
        this.color = color;


    }
    public Dog(String name, String color,  int age){
        super(age);
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}';
    }

    @Override
    public void makeNoise(){
        System.out.println("Gau gau....!!!");
    }

    @Override
    public void printAnimalInfo(){
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



}
