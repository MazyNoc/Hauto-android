package nu.annat.autohome;

import android.view.View;

import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.databinding.SwitchRowBinding;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwitchViewHolder extends BaseViewHolder<SwitchUnit, SwitchRowBinding> {

	public SwitchViewHolder(SwitchRowBinding binding) {
		super(binding);
		binding.setHandler(this);
	}

	public void toggle() {
		SwitchUnit unit = data;
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

	@Override
	public void setData(SwitchUnit sensor) {
		super.setData(sensor);
		if (sensor == null) {
		} else {
			binding.setVariable(BR.data, sensor);
		}
		binding.executePendingBindings();
	}
}
