package unit06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private String email;

    public Student(int id, String name, String email){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getName(){return this.name;}

    @Override
    public String toString(){
        return "Student {ID: "+id+", Name: "+name+", Email: "+email+ "}";
    }

    @Override
    public int hashCode(){
        int hash = (int) Math.pow(name.hashCode(), id);
        return hash;
    }

    @Override
    public int compareTo(Student other){
        return this.id - other.id;
    }

    public static void main(String[] args){
        Set<Student> ha = new HashSet<>();
        Set<Student> tr = new TreeSet<>();

        Student stu1 = new Student(2002, "bob", "k");
        Student stu2 = new Student(2941, "cy", "k");
        Student stu3 = new Student(2632, "jer", "k");
        Student stu4 = new Student(2527, "leo", "k");
        Student stu5 = new Student(2527, "leo", "k");

        ha.add(stu1);
        ha.add(stu2);
        ha.add(stu3);
        ha.add(stu4);
        ha.add(stu5);

        tr.add(stu1);
        tr.add(stu2);
        tr.add(stu3);
        tr.add(stu4);
        tr.add(stu5);

        Map<String,Student> hm = new HashMap<>();
        Map<String,Student> tm = new TreeMap<>();

        hm.put(stu1.getName(),stu1);
        hm.put(stu2.getName(),stu2);
        hm.put(stu3.getName(),stu3);
        hm.put(stu4.getName(),stu4);
        hm.put(stu5.getName(),stu5);

        System.out.println(ha);
        System.out.println(tr);

        for(String name: hm.keySet()){
            System.out.println(hm.get(name));
        }
        System.out.println("===========");
        tm.put(stu1.getName(),stu1);
        tm.put(stu2.getName(),stu2);
        tm.put(stu3.getName(),stu3);
        tm.put(stu4.getName(),stu4);
        tm.put(stu5.getName(),stu5);
        for(String name: tm.keySet()){
            System.out.println(tm.get(name));
        }
    }
}
