package unit09.practicum;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMaker {
    

    public static List<Course> makeSchedule(List<Course> courses){
        //start by finding the course that starts at the earliest time
        //then after find all courses that can be put after it and find the closest
        //if there are two taht can fit then pick the shortest class
        //it should always return the smallest as long as course one is not long
        List<Course> fin = new ArrayList<>();
        Course cur = null;
        for(Course cou : courses){
            if(cur==null){
                cur = cou;
            }
            if(cur.getStart()>cou.getStart()){
                cur = cou;
            }
            else if(cur.getStart()==cou.getStart()){
                if(cur.getEnd()>cou.getEnd()){
                    cur=cou;
                }
            }
        }
        fin.add(cur);
        while(true){
            cur = null;
            for(Course cou : courses){
                if(fin.contains(cou)==false){
                    if(cou.getStart()==fin.get(fin.size()-1).getEnd()){
                        if(cur!=null){
                            if(cur.getEnd()>cou.getEnd()){
                                cur = cou;
                            }
                        }
                        else{
                            cur=cou;
                        }
                    }
                    else if(cou.getStart()>fin.get(fin.size()-1).getEnd()){
                        if(cur!=null){
                            if(cur.getEnd()>cou.getEnd()){
                                cur = cou;
                            }
                        }
                        else{cur=cou;}
                    }
                }
            }
            if(cur!=null){fin.add(cur);}
            else{break;}
        }
        return fin;
    }

    public static void main(String[] args){
        List<Course> test = Course.exampleCourses();
        List<Course> fin = makeSchedule(test);
        System.out.println(fin.toString());
    }
}
