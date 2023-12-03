package unit11.activities;

public class TheCount implements Runnable{
    private static int[] COUNT = new int[1];
    private int id;

    public TheCount(int id){
        this.id = id;
    }

    @Override
    public void run(){
        synchronized(COUNT){
        System.out.println(id);
        for(int i =0;i<100000;i++){
            COUNT[0] = COUNT[0]+1;
        }
        System.out.println(id);
    }
    }

    public static void main(String[] args) throws InterruptedException{
        for(int i =0;i<10;i++){
            Thread th = new Thread(new TheCount(i+1));
            th.start();
            th.join();}
        Thread.sleep(1000);
        System.out.println(COUNT[0]);
    }
}
