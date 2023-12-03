package unit09.series;

import java.util.stream.Stream;

public class Series{
    private static double product;

    public static Stream<Double> buildStream(int n){
        Stream.Builder <Double> builder = Stream.builder();{
            for(int i =1; i<=n; i++){
                builder.add((double)i);
            }
        }
        return builder.build();
    }
    

    public static int factForEach(int num){
        product =1;
        Stream<Double> st = buildStream(num);
        st.forEach((val)->product*=val);
        return (int)product;
    }

    public static int factReduce(int num){
        Stream<Double> st = buildStream(num);
        double ret = st.reduce((x,y) ->x*y).get();
        return (int)ret;
    }

    public static double piGregoryLeibniz(int num){
        Stream<Double> st = buildStream(num);
        double ret = st.mapToDouble((va)->Math.pow(-1, va)/(va*2+1)).sum();
        ret += 1.0;
        return ret*4;
    }

    public static double piNilikantha(int num){
        Stream<Double> st = buildStream(num);
        double ret = st.mapToDouble((va)->(Math.pow(-1, va+1)*4)/((va*2)*(va*2+1)*(va*2+2))).sum();
        return ret+3;
    }

    public static void main(String[] args){
        System.out.println(factForEach(3));
        System.out.println(factForEach(4));
        System.out.println(factForEach(5));
        System.out.println(factReduce(3));
        System.out.println(factReduce(4));
        System.out.println(factReduce(5));
        System.out.println(piGregoryLeibniz(10000000));
        System.out.println(piNilikantha(1000));
    }
}