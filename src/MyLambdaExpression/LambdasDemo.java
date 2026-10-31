package MyLambdaExpression;
import java.util.List;

public class LambdasDemo {

    public static void printPeopleOlderThan(List<Person> people, int age){
        for(Person p: people){
            if(p.getAge() > age){
                p.printPerson();
            }
        }
    }
    public static void printPeopleWithinAgeRange(List<Person> people, int low, int high){
        for(Person p: people){
            if(p.getAge() >= low && p.getAge() <= high){
                p.printPerson();
            }
        }
    }
    public static class EvaluadorDePersonasSegunRequerimiento implements I_Evaluacion{
        @Override
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE && p.getAge() >= 13 && p.getAge() <= 16;
        }
    }

    public static void printPeople(List<Person> people, I_Evaluacion eval){
        for(Person p: people){
            if(eval.test(p)){
                p.printPerson();
            }
        }
    }
    //-------------------------------------------------------------------------------\\
    public static void main(String[] args){
        List<Person> people = Person.createDefaultListOfPeople();
        //printPeopleOlderThan(people, 1);
        //printPeopleWithinAgeRange(people, 13, 16);
        printPeople(people, p -> p.getAge() >= 1 && p.getAge() <= 100);
    }
}
