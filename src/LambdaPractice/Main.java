package LambdaPractice;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPeopleOlderThan(List<Person> people, int age){
        for( Person p: people){
            if(p.age > age){
                p.printPerson();
            }
        }
    }
    public static void printPeopleBetweenAgeRange(List<Person> people, int low, int high){
        for (Person p: people){
            if(p.getAge() >= low && p.getAge() <= high){
                p.printPerson();
            }
        }
    }

    public static void printPeople(List<Person> people, CheckPerson a){
        for(Person p: people){
            if(a.evaluateQuery(p)){
                p.printPerson();
            }

        }
    }

    public static void main(String[] args){
        List<Person> people = Person.setDefaultValues();

        //printPeopleOlderThan(people, 28);
        //printPeopleBetweenAgeRange(people, 15, 25);
        //printPeople(people, new CheckPersonImplementationOne());

        printPeople(people,  p -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 15 && p.getAge() <= 30 );
    }
}
