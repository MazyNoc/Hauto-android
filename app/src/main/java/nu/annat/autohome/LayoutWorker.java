package nu.annat.autohome;

import nu.annat.autohome.api.Sensor;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.rest.Api;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayoutWorker extends BaseWorker{
	public void changeSensor(SwitchUnit sensor, boolean b) {
		sensor.setOn(b);
		Server.getInstance().getService().executeSwitchOutlet(sensor.id, sensor.isOn()?"start":"stop").enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {

			}
		});
	}
}
