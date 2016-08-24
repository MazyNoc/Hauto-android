package nu.annat.autohome.api;

import java.util.Comparator;

public class Unit {
    public String type;
    public String id;
    public String name;


    // radiobuttons
    public String[] buttons;

    public Unit() {
        name = this.getClass().getSimpleName();
    }

    public static Comparator<Unit> compareName() {
        return (o1, o2) -> o1.name.compareTo(o2.name);
    }
}
