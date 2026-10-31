package MyLambdaExpression;
import java.util.ArrayList;
import java.util.List;

public class Person {
    public enum Sex {MALE, FEMALE};
    String name;
    int age;
    String emailAddress;
    Sex gender;

    public Person(){
    }

    public Person(String name, int age, String emailAddress, Sex gender){
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public String getName(){ return name; }
    public int getAge(){ return age; }
    public String getEmailAddress() { return emailAddress; }
    public Sex getGender() { return gender; }
    public void setName(String name){ this.name = name; }
    public void setAge(int age){ this.age = age; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setGender(Sex gender){ this.gender = gender; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +

                ", gender=" + gender +
                '}';
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static List<Person> createDefaultListOfPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan", 15, "juan@gmail.com",Sex.MALE));
        people.add(new Person("Josefina", 12, "josefina@gmail.com", Sex.FEMALE));
        people.add(new Person("Pedro", 17, "pedro@gmail.com", Sex.MALE));
        people.add(new Person("Alice", 14, "alice@gmail.com", Sex.FEMALE));
        return people;
    }
}
