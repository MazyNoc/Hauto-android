package nu.annat.autohome.api;

import java.util.Comparator;

public class Sensor {
    public String id;
    public String name;
    public boolean isOn;

    public static Comparator<Sensor> compareName() {
        return (o1, o2) -> o1.name.compareTo(o2.name);
    }
}
