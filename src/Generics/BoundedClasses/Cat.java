package Generics.BoundedClasses;

public class Cat extends Animal{
    private String name;
    private String color;
    private int livesLeft;

    public Cat(String name, String color, int livesLeft){
        super();
        this.name = name;
        this.color = color;
        this.livesLeft = livesLeft;

    }
    public Cat(String name, String color, int livesLeft, int age){
        super(age);
        this.name = name;
        this.color = color;
        this.livesLeft = livesLeft;
    }
    public Cat(){
        super();
        this.name = "Michin";
        this.color = "Undefined";
        this.livesLeft = 9;
    }

    @Override
    public void makeNoise(){
        System.out.println("Miau miauuuu...");
    }

    public String makeCatNoise() {
        return "Miu miu!!";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", livesLeft=" + livesLeft +
                '}';
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

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

}
