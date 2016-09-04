package nu.annat.autohome.api;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class Unit extends BaseObservable implements Comparable<Unit> {
	public String type;
	public String id;
	public String name;

	// radiobuttons
	public String[] buttons;

	public Unit() {
		name = this.getClass().getSimpleName();
	}

//    public static Comparator<Unit> compareName() {
//        return (o1, o2) -> o1.name.compareTo(o2.name);
//    }

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	@Bindable
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Unit unit) {
		return name.compareTo(unit.name);
	}
}
