package unit09.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a student with a first and last na
 */
public class Student implements Comparable<Student> { // remove Comparable
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    public interface Sort{
        void sort(Student a, Student b);
    }
    public static int combareByFirstname(Student a, Student b){
        return a.getFirstName().compareTo(b.getFirstName());
    }

    public static void main(String[] args){
        List<Student> ret = new ArrayList<>();
        ret.add(new Student("Ray", "Rob"));
        ret.add(new Student("Cyt", "IDK"));
        ret.add(new Student("Rob", "Johnsom"));
        ret.add(new Student("Adam", "Reynold"));

        ret.sort(Student::combareByFirstname);

        System.out.println(ret.toString());
        ret.stream().forEach(e -> System.out.println(e.getFirstName()+" "+e.getLastName()));

        ret.stream().filter(s -> s.toString().toLowerCase().contains("t")).forEach(s->System.out.println(s.getFirstName()+" "+s.getLastName()));
    }
}
