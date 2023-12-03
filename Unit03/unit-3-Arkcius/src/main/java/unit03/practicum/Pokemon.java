package unit03.practicum;

public class Pokemon{
    private String name;
    private int level;
    private PokemonType type;

    public Pokemon(String name, PokemonType type, int level){
        this.name = name;
        this.level = level;
        this.type = type;
    }
    public Pokemon(String name, PokemonType type){
        this.name = name;
        this.level = 1;
        this.type = type;
    }

    public String getName(){return this.name;}
    public void setName(String name2){
        this.name = name2;}

    public PokemonType getType(){return this.type;}
    public int getLevel(){return this.level;}

    public void levelUp(){
        if(this.level<100){
            this.level += 1;
        }

    }

    @Override
    public String toString(){
        return "Pokemon{Name = "+this.name+", Type = "+this.type+", Level = "+this.level+"}";

    } 
    @Override
    public boolean equals(Object obj){
        Pokemon other = (Pokemon) (obj);
        if(obj instanceof Pokemon){
            return ((this.type == other.type)&&(this.level==other.level));
        }
        else{
            return false;
        }
    } 
    }

