package unit09.inner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendar {
    public enum DayOfWeek{
        SUNDAY(0,"Sun"),
        MONDAY(1,"Mon"),
        TUESDAY(2,"Tue"),
        WEDNESDAY(3,"Wed"),
        THURSDAY(4,"Thr"),
        FRIDAY(5,"Fri"),
        SATURDAY(6,"Sat");
        private int number;
        private String shortName;
        private static final Map<DayOfWeek,DayOfWeek> NEXT_DAYS = new HashMap<>();
        static{
            NEXT_DAYS.put(SUNDAY,MONDAY);
            NEXT_DAYS.put(MONDAY,TUESDAY);
            NEXT_DAYS.put(TUESDAY,WEDNESDAY);
            NEXT_DAYS.put(WEDNESDAY,THURSDAY);
            NEXT_DAYS.put(THURSDAY,FRIDAY);
            NEXT_DAYS.put(FRIDAY,SATURDAY);
            NEXT_DAYS.put(SATURDAY,SUNDAY);
        }

        private DayOfWeek(int number, String shortname){
            this.number = number;
            this.shortName = shortname;
        }

        public DayOfWeek tomorrow(){
            return NEXT_DAYS.get(this);
        }
        @Override
        public String toString(){
            return this.name()+"("+number+", \""+shortName+"\")";
        }
    }

    public enum Month implements Iterable<DayOfWeek>{
        JANUARY(31),
        FEBUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int daysInMonth;
        private DayOfWeek startDay;
        private static final Map<Month,Month> NEXT_MONTHS = new HashMap<>();
        static{
            NEXT_MONTHS.put(JANUARY,FEBUARY);
        }
        private Month(int daysInMonth){
            this.daysInMonth=daysInMonth;
            startDay = DayOfWeek.SUNDAY;
        }
        public Month nextMonth(){
            return NEXT_MONTHS.get(this);
        }
        public void setStartDay(DayOfWeek day){
            startDay=day;
        }

        @Override
        public String toString(){
            return this.name().toLowerCase().substring(0,3);
        }
        @Override
        public Iterator<DayOfWeek> iterator() {
            return new Iterator<DayOfWeek>(){
                private int counter =1;
                private DayOfWeek day = startDay;
                public boolean hasNext() {
                    return counter<=daysInMonth;
                }
                public DayOfWeek next() {
                    DayOfWeek temp = day;
                    counter++;
                    day = day.tomorrow();
                    return temp;
                }  
            };
        }
    }
    public static DayOfWeek printMonth(Month month, DayOfWeek startDay){
        month.setStartDay(startDay);
        int counter =1;
        DayOfWeek lastDay = null;
        System.out.println(month.name());
        int dayNumber = 1;
        for(int i = 0; i<startDay.number;i++){
            System.out.print(String.format("%7", ""));
            counter++;
        }
        for(DayOfWeek day : month){
            System.out.print(String.format("%7s",dayNumber+"-"+day.shortName));
            if(counter%7==0){System.out.println();}
            lastDay = day;
            counter++;
            dayNumber++;
        }
        if(counter%7!=0){
            System.out.println();
        }
        return lastDay;
    }
    public static void printYear(int year, DayOfWeek startDay){
        System.out.println(year);
        for(Month mon : Month.values()){
            startDay = printMonth(mon, startDay);
            System.out.println();
        }
    }

        public static void main(String[] args){
            printMonth(Month.MARCH,DayOfWeek.SUNDAY);
            printYear(2023, DayOfWeek.FRIDAY);
        }
    
}
