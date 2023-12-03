public class Basics{
    public static void multiple(){
        int cur = 1;
        while(cur<100){
            if(cur%3==0||cur%7==0){
                if(cur%3==0&&cur%7==0){
                }
                else{
                    System.out.println(cur);
                }
            }
            cur++;
        }
    }
    public static void main(String[] args){
        multiple();
    }
}
