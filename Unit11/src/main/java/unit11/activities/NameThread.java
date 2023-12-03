package unit11.activities;

public class NameThread implements Runnable {
    private String st;

    public NameThread(String st){
        this.st = st;
    }

    @Override
    public void run(){
        System.out.print(st);
    }

    public static void main(String[] args) throws InterruptedException{
        String name = "Ryan";
        for(int i =0; i<name.length();i++){
            Thread n = new Thread(new NameThread(name.substring(i, i+1)));
            n.start();
            n.join();
        }
        System.out.println("!");


    }
}
