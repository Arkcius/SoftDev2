package unit02;
import unit02.swb.Weapon;

import java.util.Arrays;

import unit02.swb.DamageType;
import unit02.swb.Ship;


public class StarWarsBattle{
    public static final String aq = "Aquila";
    public static final String pic = "Piceses";
    public static final String ba = "Ballista MK1";
    public static final String ba2= "Ballista MK2";
    public static void main(String[] args){
        Weapon ballista = new Weapon(ba,2,DamageType.HEAVY);
        Weapon ballista2 = new Weapon(ba2,2,DamageType.HEAVY);
        Ship aquila = new Ship(aq,1000,10,ballista);
        Ship picese = new Ship(pic,1000);
        System.out.println(ballista);
        System.out.println(aquila);
        System.out.println(picese);
        boolean a = ballista.equals(ballista2);
        System.out.println(a);

        String heavyDamage = DamageType.HEAVY.toString();
        System.out.println(heavyDamage);
        String normalDamage = DamageType.NORMAL.toString();
        System.out.println(normalDamage);
        String ionDamage = DamageType.ION.toString();
        System.out.println(ionDamage);
        DamageType[] damageValues = DamageType.values();
        System.out.println(Arrays.toString(damageValues));
    }
}
