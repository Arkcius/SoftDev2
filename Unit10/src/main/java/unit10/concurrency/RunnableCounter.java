package unit10.concurrency;

public class RunnableCounter implements Runnable {
    private String name;

    public RunnableCounter(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=1; i<101; i++){
            System.out.println(name+": "+i);
        }
    }

    public static void main(String[] args){
        Runnable ex = new RunnableCounter("Test");
        Thread example = new Thread(ex);
        example.start();
    }
}
