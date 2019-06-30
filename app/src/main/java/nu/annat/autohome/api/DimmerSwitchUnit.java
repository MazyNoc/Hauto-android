package nu.annat.autohome.api;

import androidx.databinding.Bindable;

import nu.annat.autohome.BR;

public class DimmerSwitchUnit extends SwitchUnit {

	protected float value;

	@Bindable
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
		notifyPropertyChanged(BR.value);
	}

}
