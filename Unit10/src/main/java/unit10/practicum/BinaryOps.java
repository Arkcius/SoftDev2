package unit10.practicum;

public class BinaryOps {
    public interface BinaryLogicalOp{
        boolean compute(boolean a,boolean b);
    }

    public static void main(String[] args){
        boolean a =true;
        boolean b = false;
        BinaryLogicalOp and = new BinaryLogicalOp() {
            public boolean compute(boolean a,boolean b){
                if(a==true&&b==true){
                    return true;
                }
                else{return false;}
            }
        };
        BinaryLogicalOp or = new BinaryLogicalOp() {
            public boolean compute(boolean a,boolean b){
                if(a==true){return true;}
                else if(b==true){return true;}
                return false;
            }
        };
        BinaryLogicalOp xor = new BinaryLogicalOp() {
            public boolean compute(boolean a,boolean b){
                if(a==b){return false;}
                else if(a==true){return true;}
                else{return true;}
            }
        };
        
        System.out.println("A: "+b+", B: "+b+", AND: "+and.compute(b, b)+", OR: "+or.compute(b, b)+", XOR: "+xor.compute(b, b));
        System.out.println("A: "+a+", B: "+b+", AND: "+and.compute(a, b)+", OR: "+or.compute(a, b)+", XOR: "+xor.compute(a, b));
        System.out.println("A: "+b+", B: "+a+", AND: "+and.compute(b, a)+", OR: "+or.compute(b, a)+", XOR: "+xor.compute(b, a));
        System.out.println("A: "+a+", B: "+a+", AND: "+and.compute(a, a)+", OR: "+or.compute(a, a)+", XOR: "+xor.compute(a, a));


    }
}
