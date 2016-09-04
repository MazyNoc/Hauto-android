package nu.annat.autohome.api;

import java.util.Comparator;

public class Sensor implements Comparable<Sensor>{
    public String id;
    public String name;
    public boolean isOn;

//    public static Comparator<Sensor> compareName() {
//        return (o1, o2) -> o1.name.compareTo(o2.name);
//    }

    @Override
    public int compareTo(Sensor sensor) {
        return name.compareTo(sensor.name);
    }
}
