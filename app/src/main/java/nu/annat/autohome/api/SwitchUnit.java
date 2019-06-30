package nu.annat.autohome.api;

import androidx.databinding.Bindable;

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

	public static class Command extends Unit.Command{
		public String state;

		public Command(String state) {
			this.state = state;
		}
	}

	public Command createCommand(String state) {
		return new Command(state);
	}
}
