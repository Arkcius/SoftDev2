package unit02.chickens;

public enum Size{
    PEEWEE(15),
    SMALL(18),
    MEDIUM(21),
    LARGE(24),
    EXTRA_LARGE(27),
    JUMBO(30);

    private int oz;

    private Size(int oz){
        this.oz = oz;
    }
    public int getOZ(){return this.oz;}

}
