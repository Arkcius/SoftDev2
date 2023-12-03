package unit02.swb;


public enum DamageType{
    HEAVY("Green"),
    NORMAL("Red"),
    ION("Blue");

    private String color;

    private DamageType(String color){
        this.color = color;
    }
    public String getColor(){return this.color;}
}

