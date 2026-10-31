package LambdaPractice;

import java.util.ArrayList;

public class Person {
    public enum Sex {MALE, FEMALE};
    String name;
    String emailAddress;
    int age;
    Sex gender;

    public Person(String name, String emailAddress, int age, Sex gender) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static ArrayList<Person> setDefaultValues(){
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Juan", "juan@email.com", 23, Sex.MALE));
        people.add(new Person("Juana", "juana@email.com", 27, Sex.FEMALE));
        people.add(new Person("Pedro", "Pedro@email.com", 17, Sex.MALE));
        people.add(new Person("Pedra", "pedra@email.com", 31, Sex.FEMALE));
        people.add(new Person("Jose", "jose@email.com", 12, Sex.MALE));

        return people;
    }
}
