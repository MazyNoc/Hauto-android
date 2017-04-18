package nu.annat.autohome.api;

import android.databinding.Bindable;

import nu.annat.autohome.BR;

public class DimmerSwitchUnit extends SwitchUnit {

	protected int value;

	@Bindable
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		notifyPropertyChanged(BR.value);
	}

}
