package nu.annat.autohome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nu.annat.autohome.api.Sensor;
import nu.annat.autohome.api.SensorList;
import nu.annat.autohome.api.Unit;

public class ItemsAdapter extends RecyclerView.Adapter<OutputViewHolder> {

	private LayoutInflater inflater;
	private List<Unit> data = new ArrayList<>();

	public ItemsAdapter(List<Unit> sensors) {
		data = sensors;
	}

	@Override
	public OutputViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.sensor_row, parent, false);
		return new OutputViewHolder(view);
	}

	@Override
	public void onBindViewHolder(OutputViewHolder holder, int position) {
		holder.setData(data.get(position));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}
