package unit02;

import java.util.Arrays;
import java.util.Random;

public class Year{
    public static final int DAYS_IN_YEAR = 365;
    public static final int MAX_YEAR = 2024;
    public static final int MIN_YEAR = 1900;
    private static final Random RNG = new Random();

    private int yearNumber;

    public Year(int year){
        this.yearNumber = year;

    }
    /**
     * 
     * @return year number
     */
    public int getYearNumber(){return this.yearNumber;}
    public int numberOfDays(){
        return daysInYear(this.yearNumber);
    }

    public static Year[] parseYears(String years){
        String[] tokens = years.split(" ");
        Year[] array = new Year[tokens.length];
        for(int i=0;i<tokens.length;i++){
            int yearNumber = Integer.parseInt(tokens[i]);
            array[i] = new Year(yearNumber);
        }
        return array;
    }

    public static int daysInYear(int year){
        if((year%400==0)||(year%4==0&&year%100!=0)){
            return DAYS_IN_YEAR+1;
        }
        else{
            return DAYS_IN_YEAR;
        }
    }

    public static Year getRandomYear(){
        int rand = RNG.nextInt(MIN_YEAR,MAX_YEAR);
        return new Year(rand);
    }

    @Override
    public String toString(){
        return "Days in "+this.getYearNumber()+": "+daysInYear(this.getYearNumber());
    }


    public static void main(String[] args){
      Year y2020 = new Year(2020);
      System.out.println(y2020);
      Year y2022 = new Year(2022);
      System.out.println(y2022);
      Year y2024 = new Year(2024);
      System.out.println(y2024);
      Year y2023 = new Year(2023);
      System.out.println(y2023);
      Year[] token = parseYears("1975 2000 1952");
      System.out.println(Arrays.toString(token));
      System.out.println(getRandomYear());
      System.out.println(getRandomYear());
      System.out.println(getRandomYear());
      System.out.println(getRandomYear());
    }
}
