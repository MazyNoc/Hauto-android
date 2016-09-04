package nu.annat.autohome.api;

import java.util.List;

public class Layout implements Comparable<Layout> {

	public String id;
	public String name;
	public List<String> unitIds;

//	public static Comparator<Layout> compareName() {
//		return (o1, o2) -> o1.name.compareTo(o2.name);
//	}

	@Override
	public int compareTo(Layout layout) {
		return name.compareTo(layout.name);
	}
}
