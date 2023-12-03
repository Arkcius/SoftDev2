package unit10.assignment.part2;

public class Bridge implements Runnable{
    private boolean Troll=false;

    public boolean enterBridge(){
        if(Troll==false){
            Troll = true;
            return true;
        }
        else{return false;}
    }

    public void leaveBridge(){
        Troll = false;
    }

    @Override
    public void run(){

    }

    public static void main(String[] args){

    }
}
