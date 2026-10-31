package XXXSandboxXXX;

public class Person {
    private enum Sex {FEMALE, MALE}
    private String name;
    private String email;
    private int age;
    private Sex gender;

    public Person(String name, String email, int age, Sex gender) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void printPerson(){
        System.out.println(toString());
    }

//    public List<Person> setDefaultList(){
//        //List<Person> people = new ;
//
//        //return people;
//    }
}
