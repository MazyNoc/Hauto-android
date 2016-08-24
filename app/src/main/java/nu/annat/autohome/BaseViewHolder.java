package nu.annat.autohome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import nu.annat.autohome.api.Sensor;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseViewHolder<T> extends RecyclerView.ViewHolder {

	protected T data;

	public BaseViewHolder(View itemView) {
		super(itemView);
	}

	public void setData(T data) {
		this.data = data;
	}
}
