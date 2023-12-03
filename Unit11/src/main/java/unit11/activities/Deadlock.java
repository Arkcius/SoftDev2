package unit11.activities;

public class Deadlock implements Runnable{
    private String name;
    private Object lock1;
    private Object lock2;


    public Deadlock(String name,Object lock1,Object lock2){
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run(){
        while(true){
            synchronized(lock1){
                System.out.println("Lock one");
                synchronized(lock2){
                    System.out.println("lock 2");
                }
            }
        }
    }

    public static void main(String[] args){
        String locka = "A";
        String lockb = "B";

        new Thread(new Deadlock("1", locka, lockb)).start();;
        new Thread(new Deadlock("2", lockb, locka)).start();;
    }
}
