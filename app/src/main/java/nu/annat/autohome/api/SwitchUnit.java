package nu.annat.autohome.api;

import android.databinding.Bindable;

import nu.annat.autohome.BR;

public class SwitchUnit extends Unit {
	// switch
	protected boolean isOn;


	@Bindable
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean on) {
		isOn = on;
		notifyPropertyChanged(BR.on);
	}
}
