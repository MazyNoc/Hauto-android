package nu.annat.autohome.api;

import java.util.Comparator;

public class Scene {
    public String id;
    public String name;

    public static Comparator<Scene> compareName() {
        return (o1, o2) -> o1.name.compareTo(o2.name);
    }
}
