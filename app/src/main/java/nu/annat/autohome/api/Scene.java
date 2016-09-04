package nu.annat.autohome.api;

import java.util.Comparator;

public class Scene implements Comparable<Scene>{
    public String id;
    public String name;

//    public static Comparator<Scene> compareName() {
//        return (o1, o2) -> o1.name.compareTo(o2.name);
//    }

    @Override
    public int compareTo(Scene scene) {
        return name.compareTo(scene.name);
    }
}
