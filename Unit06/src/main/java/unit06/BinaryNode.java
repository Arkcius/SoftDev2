package unit06;

public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(int value, BinaryNode right, BinaryNode left){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public int getVal(){return this.value;}
    public void setVal(int value){this.value = value;}

    public BinaryNode getRight(){return this.right;}
    public void setRight(BinaryNode node){this.right = node;}

    public BinaryNode getLeft(){return this.left;}
    public void setLeft(BinaryNode node){this.left = node;}

    @Override
    public String toString(){
        String ret = "Binary Node{Value = "+getVal()+", left = "+this.left
        +", right = "+this.right+"}";
        return ret;

    }

    public String infixTransversal(){
        String ret = "";
        if(this.left!=null){
            ret+=this.left.infixTransversal();
        }
        ret+=this.value+" ";
        if(this.right!=null){
            ret+=this.right.infixTransversal();
        }
        return ret;
    }

    public boolean search(int target){
        if(this.value==target){
            return true;
        }
        if(this.left!=null){
            if(left.search(target)){
                return true;
            }
        }
        if(this.right!=null){
            if(right.search(target)){
                return true;
            }
        }
        return false;
    }

    public void binaryInsert(int value){
        if(value<this.getVal()){
            if(this.left==null){
                this.setLeft(new BinaryNode(value));
            }
            else{this.left.binaryInsert(value);}
        }
        else if(value>this.getVal()){
            if(this.right==null){
                this.setRight(new BinaryNode(value));
            }
            else{this.right.binaryInsert(value);}
        }
    }

    public boolean binarySearch(int target){
        if(value==target){
            return true;
        }
        else if(value>target&&this.left!=null){
            if(this.left.binarySearch(target)){;
                return true;}
        }
        else if(value<target){
            return right != null ? right.binarySearch(target) : false;
        }
        return false;
    }

    public static void main(String[] args){
        BinaryNode mai = new BinaryNode(5,new BinaryNode(6),new BinaryNode(2));
        System.out.println(mai);
        System.out.println(mai.infixTransversal());
        mai.left.setRight(new BinaryNode(10));
        System.out.println(mai.search(2));
        System.out.println(mai.search(10));
        System.out.println(mai.search(6));
        System.out.println(mai.search(15));

        BinaryNode in = new BinaryNode(4);
        in.binaryInsert(2);
        in.binaryInsert(1);
        in.binaryInsert(3);
        in.binaryInsert(6);
        in.binaryInsert(5);
        System.out.println(in);
        System.out.println(in.infixTransversal());
    }
}
