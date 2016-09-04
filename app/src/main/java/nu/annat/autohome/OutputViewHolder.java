package nu.annat.autohome;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import nu.annat.autohome.databinding.SensorRowBinding;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OutputViewHolder extends BaseViewHolder<Unit, SensorRowBinding> {

	public OutputViewHolder(SensorRowBinding binding) {
		super(binding);
		binding.setHandler(this);
	}
//
//	public void OutputViewHolder(View itemView) {
//		super(itemView);
//		//final String id = this.data.id;
//
//		name = (TextView) itemView.findViewById(R.id.name);
//		onoff = (CompoundButton) itemView.findViewById(R.id.onoff);
//
//		onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//			@Override
//			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {)
//				Server.getInstance().getService().setOutlet(data.id, b ? "start" : "stop").enqueue(new Callback<ResponseBody>() {
//					@Override
//					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//					}
//
//					@Override
//					public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//					}
//				});
//			}
//		});
//	}

	public void toggle(){
		SwitchUnit unit = (SwitchUnit) data;
		unit.setOn(!unit.isOn());
		Server.getInstance().getService().setOutlet(data.id, unit.isOn() ? "start" : "stop").enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {

			}
		});

	}

	public void onCheckedChange(View view, Boolean b) {
	}

	@Override
	public void setData(Unit sensor) {
		super.setData(sensor);
		if (sensor == null) {
//			name.setText("Missing");
//			onoff.setEnabled(false);
//			onoff.setChecked(false);
		} else {
			binding.setVariable(BR.data,sensor);
		}
		binding.executePendingBindings();
	}
}
