package PresidentialElections;

public class Dove extends Bird implements MessageSender{
    public String name;

    public Dove(String name, String color, int age){
        super(color, age);
        this.name = name;
    }

    public Dove(String name){
        super();
        this.name = name;
    }
    public void releaseDove(){
        System.out.println("Letting the bird fly...");
    }
    @Override
    public void sendMessage(String message){
        releaseDove();
        System.out.println("The " + super.color + " dove is delivering the message: \" " + message + "\"");
        System.out.println();
    }
}
