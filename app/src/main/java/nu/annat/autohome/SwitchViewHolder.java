package nu.annat.autohome;

import android.view.View;

import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.databinding.SwitchRowBinding;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwitchViewHolder extends BaseViewHolder<SwitchUnit, SwitchRowBinding> implements View.OnClickListener{

	public SwitchViewHolder(SwitchRowBinding binding) {
		super(binding);
		binding.setHandler(this);
		binding.ripple.setOnClickListener(this);

	}

	public void toggle() {
		SwitchUnit unit = data;
		unit.setOn(binding.ripple.isOn());
		Server.getInstance().getService().setOutlet(data.id, unit.isOn() ? "start" : "stop").enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
			//	binding.getData().to
			}
		});
	}

	@Override
	public void setData(SwitchUnit sensor) {
		super.setData(sensor);
		if (sensor == null) {
		} else {
			binding.setVariable(BR.data, sensor);
			binding.ripple.setState(sensor.isOn());
		}
		binding.executePendingBindings();
	}

	@Override
	public void onClick(View view) {
		toggle();
	}
}
