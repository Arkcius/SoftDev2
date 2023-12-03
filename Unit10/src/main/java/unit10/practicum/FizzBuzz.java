package unit10.practicum;

import java.util.stream.Stream;

public class FizzBuzz{
    public static void main(String[] args){
        Stream.Builder<Integer> build = Stream.builder(); {
            for(int i=0; i<100; i++){
                build.add(i+1);
            }
        }
        Stream<Integer> st = build.build();
        st.filter(c->(c%3==0&&c%5==0)).forEach(c->System.out.println("FizzBuzz: "+c));
    }
}