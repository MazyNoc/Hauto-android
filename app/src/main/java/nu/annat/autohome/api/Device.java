package nu.annat.autohome.api;

import java.util.Comparator;

public class Device {
    public String id;
    public String name;
    public String ip;
    public String type;

    public static Comparator<Device> compareName() {
        return (o1, o2) -> o1.name.compareTo(o2.name);
    }
}
