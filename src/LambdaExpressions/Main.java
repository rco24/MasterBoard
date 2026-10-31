package LambdaExpressions;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    @FunctionalInterface
    public interface CheckPerson {
        boolean test(Person p);
    }

    static class CheckPersonEligibleForSelectiveSearch implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.gender == Person.Sex.FEMALE &&
                    p.getAge() >= 18 &&
                    p.getAge() <= 25;
        }
    }

//    public static void printPersonOlderThan(List<Person> people, int age){
//        for(Person p: people){
//            if(p.getAge() >= age){
//                p.printPerson();
//            }
//        }
//    }
//
//    public static void printPersonWithinAgeRange(List<Person> people, int low, int high){
//        for(Person p: people){
//            if(low <= p.getAge() && p.getAge() < high){
//                p.printPerson();
//            }
//        }
//    }

    public static void printPeople(List<Person> people, CheckPerson tester){
        for(Person p: people){
            if(tester.test(p)){
                p.printPerson();
            };
        }
    }
    public static void printPeopleWithPredicate(List<Person> people, Predicate<Person> tester){
        for(Person p: people){
            if(tester.test(p)){
                p.printPerson();
            };
        }
    }
    public static void main(String[] args){
        List<Person> people = Person.generateDefaultList();


//        printPersonOlderThan(people, 5);
//        printPersonWithinAgeRange(people, 15, 21);

//        printPeople(people, new CheckPersonEligibleForSelectiveSearch());

//        printPeople(people, new CheckPerson() {
//            @Override
//            public boolean test(Person p) {
//                return p.gender == Person.Sex.FEMALE &&
//                        p.getAge() >= 18 &&
//                        p.getAge() <= 25;
//            }
//        });

//        printPeople(people, p -> p.gender == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25);
//        printPeopleWithPredicate(people, p -> p.gender == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25);

        printPeople(people, p -> 5 == 5);

        printPeople(people, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return false;
            }
        });
    }
}
