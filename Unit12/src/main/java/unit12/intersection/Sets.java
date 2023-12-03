package unit12.intersection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    private static final int MAX = 10000;
    private static String[] users = new String[MAX];
    private static Random RNG = new Random(1);
    static {
        for (int i = 0; i < MAX; i++) {
            String user = "";
            for (int j = 0; j < 3; j++) {
                user += (char) RNG.nextInt('a', 'z' + 1);
            }
            for (int j = 0; j < 3; j++) {
                user += RNG.nextInt(10);
            }
            users[i] = user;
        }
    }

    public static Set<String> set1() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(users[i]);
        }
        return set;
    }

    public static Set<String> set2() {
        Set<String> set = new HashSet<>();
        for (int i = 3; i < 8; i++) {
            set.add(users[i]);
        }
        return set;
    }

    public static Set<String> set3() {
        Set<String> set = new HashSet<>();
        for (int i = 20; i >= 0; i--) {
            set.add(users[i]);
        }
        return set;
    }

    public static Set<String> set4() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 300; i++) {
            if (i % 5 < 2 || i % 7 == 0) {
                set.add(users[i]);
            }
        }
        return set;
    }

    public static Set<String> set5() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            if (i % 6 > 4 || i % 14 == 0) {
                set.add(users[i]);
            }
        }
        return set;
    }

    // set1 /\ set2
    public static Set<String> set1_2() {
        Set<String> s = set1();
        Set<String> c = set2();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    // set1 /\ set3
    public static Set<String> set1_3() {
        Set<String> s = set1();
        Set<String> c = set3();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    // set2 /\ set3
    public static Set<String> set2_3() {
        Set<String> s = set2();
        Set<String> c = set3();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    // set2 /\ set4
    public static Set<String> set2_4() {
        Set<String> s = set2();
        Set<String> c = set4();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    // set3 /\ set4
    public static Set<String> set3_4() {
        Set<String> s = set3();
        Set<String> c = set4();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    // set4 /\ set5
    public static Set<String> set4_5() {
        Set<String> s = set4();
        Set<String> c = set5();
        Set<String> intersection = new HashSet<>();
        for (String e : s) {
            if (c.contains(e)) {
                intersection.add(e);
            }
        }
        return new TreeSet<>(intersection);
    }

    public static void main(String[] args) {
        System.out.println("set1 = " + set1());
        System.out.println("set2 = " + set2());
        System.out.println("set3 = " + set3());
        System.out.println("set1 and set2 = " + set1_2());
        System.out.println("set1 and set3 = " + set1_3());
        System.out.println("set2 and set3 = " + set2_3());
        System.out.println("set2 and set4 = " + set2_4());
        System.out.println("set3 and set4 = " + set3_4());
        System.out.println("set4 and set5 = " + set4_5());
    }
}
