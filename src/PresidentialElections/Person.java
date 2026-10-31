package PresidentialElections;

public class Person implements MessageSender {
    public String name;
    public String lastName;


    public Person(){
        name = "An anonimus";
        lastName = "Friend of the Party";
    }

    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(name + " " + lastName + " is delivering house by house the message: \"" +  message + "\"");
        System.out.println();
    }
}
