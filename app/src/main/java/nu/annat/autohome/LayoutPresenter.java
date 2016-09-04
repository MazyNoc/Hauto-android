package nu.annat.autohome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import nu.annat.autohome.api.Layout;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;

public class LayoutPresenter extends BasePresenter<LayoutWorker> {

	private final Layout layout;
	private final LayoutInflater inflater;

	public LayoutPresenter(View root, Layout layout, LayoutWorker worker) {
		super(root, worker);
		this.inflater = LayoutInflater.from(root.getContext());
		this.layout = layout;
		prepare();
	}

	@Override
	protected void prepare() {
		ViewGroup content = (ViewGroup) root.findViewById(R.id.content);
		content.removeAllViews();

		Storage storage = Storage.getInstance();
		for (String unitId : layout.unitIds) {
			final Unit sensor = storage.getSensorId(unitId);

			if (sensor instanceof SwitchUnit) {
				final SwitchUnit switchSensor = (SwitchUnit) sensor;
				View inflate = inflater.inflate(R.layout.item_switch, content, false);
				CompoundButton onoff = (CompoundButton) inflate.findViewById(R.id.onoff);
				onoff.setTag(switchSensor);
				onoff.setText(switchSensor.name);
				onoff.setChecked(switchSensor.isOn());
				onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
						worker.changeSensor(switchSensor, b);
					}
				});
				content.addView(inflate);
			}
		}
	}
}
