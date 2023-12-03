package unit06.HW1;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryNode<E> root;
    private int size;

    public BinarySearchTree(E initial){
        this.size = 0;
        this.root = new BinaryNode<E>(initial);
    }

    @Override
    public String toString(){
        return root.infixTraversal();
    }

    public int size(){return this.size;}

    private boolean search(BinaryNode<E> node, E target){
        if(node.getValue().compareTo(target)==0) {
            return true;
        } else if(node.getValue().compareTo(target)>0) {
            return node.getLeft() != null ? search(node.getLeft(),target) : false;
        } else {
            return node.getRight() != null ? search(node.getRight(),target) : false;
        }
    }

    public boolean search(E target){
        return search(root,target);
    }

    private void insert(BinaryNode<E> node, E value){
        if(node.getValue().compareTo(value)>0) {
            if(node.getLeft() != null) {
                insert(node.getLeft(),value);
            } else {
                node.setLeft(new BinaryNode<>(value));
            }
        } else {
            if(node.getRight() != null) {
                insert(node.getRight(),value);
            } else {
                node.setRight(new BinaryNode<>(value));
            }
        }
    }

    public void insert(E value){
        insert(root, value);
    }


    }


