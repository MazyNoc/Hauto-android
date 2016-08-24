package nu.annat.autohome;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OutputViewHolder extends BaseViewHolder<Unit> {
	private final TextView name;
	private final CompoundButton onoff;

	public OutputViewHolder(View itemView) {
		super(itemView);
		name = (TextView) itemView.findViewById(R.id.name);
		onoff = (CompoundButton) itemView.findViewById(R.id.onoff);
		onoff.setOnCheckedChangeListener((compoundButton, b) -> {
			Server.getInstance().getService().setOutlet(this.data.id, b ? "start" : "stop").enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

				}

				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {

				}
			});
		});
	}

	@Override
	public void setData(Unit sensor) {
		super.setData(sensor);
		if (sensor == null) {
			name.setText("Missing");
			onoff.setChecked(false);
		} else {
			name.setText(sensor.name);
			onoff.setChecked(((SwitchUnit) sensor).isOn);
		}
	}
}
