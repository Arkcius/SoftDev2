package unit10.concurrency;


public class CounterThread extends Thread {
    private String name;

    public CounterThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=1; i<101; i++){
            System.out.println(name+": "+i);
        }
    }

    public static void main(String[] args){
        Thread counter1 = new CounterThread("Ryan");
        counter1.start();
        while(counter1.isAlive()){
            try{
                counter1.sleep(1000);
            }
            catch(InterruptedException ie){}
        }
        for(char c = 'A';c<='Z';c++){
            System.out.print(c+" ");
        }

    }
}
