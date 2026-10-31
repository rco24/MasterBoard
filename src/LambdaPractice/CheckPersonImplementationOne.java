package LambdaPractice;

public class CheckPersonImplementationOne implements CheckPerson{
    @Override
    public boolean evaluateQuery(Person p) {
        return p.getGender() == Person.Sex.FEMALE && p.getAge() >= 15 && p.getAge() <= 30;
    }
}
