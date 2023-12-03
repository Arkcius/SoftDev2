package unit06;

public class Pokedex {
    private BinaryNode bst;

    public Pokedex(){
        this.bst = null;
    }

    public void addPokemon(int number){
        if(containsPokemon(number)==false){
        if(bst==null){
        bst=new BinaryNode(number);}
        else{
            bst.binaryInsert(number);
        }}
    }

    public boolean containsPokemon(int number){
        return bst!= null ? bst.binarySearch(number): false;
    }
    @Override
    public String toString(){
        return bst != null ? bst.infixTransversal(): "<Empty Pokedex>";
    }

    public static void main(String[] args){
        Pokedex dex = new Pokedex();
        System.out.println(dex);
        dex.addPokemon(39);
        dex.addPokemon(4);
        dex.addPokemon(147);
        dex.addPokemon(75);
        dex.addPokemon(129);
        dex.addPokemon(129);
        System.out.println(dex);
        System.out.println(dex.containsPokemon(129));
    }
}
