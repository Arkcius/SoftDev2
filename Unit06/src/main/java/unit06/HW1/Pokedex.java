package unit06.HW1;

public class Pokedex {
    private BinarySearchTree<Integer> bst;

    public Pokedex() {
        bst = null;
    }

    public boolean containsPokémon(int number) {
        return bst != null ? bst.search(number) : false;
    }

    public void addPokémon(int number) {
        if(!containsPokémon(number)) {
            if(bst == null) {
                bst = new BinarySearchTree<>(number);
            } else {
                bst.insert(number);
            }
        }
    }

    @Override
    public String toString() {
        return bst != null ? bst.toString() : "<empty Pokédex>";
    }

    public static void main(String[] args) {
        Pokedex pokédex = new Pokedex();
        pokédex.addPokémon(113);
        pokédex.addPokémon(2);
        pokédex.addPokémon(25);
        pokédex.addPokémon(39);
        pokédex.addPokémon(63);
        pokédex.addPokémon(135);
        pokédex.addPokémon(143);
        pokédex.addPokémon(8);
        pokédex.addPokémon(4);
        pokédex.addPokémon(4);
        pokédex.addPokémon(446);

        System.out.println(pokédex);

        System.out.println("7: " + pokédex.containsPokémon(7));
        System.out.println("446: " + pokédex.containsPokémon(446));
        System.out.println("1: " + pokédex.containsPokémon(1));
        System.out.println("57: " + pokédex.containsPokémon(57));
        System.out.println("23: " + pokédex.containsPokémon(23));
        System.out.println("143: " + pokédex.containsPokémon(143));
    }
    
}
