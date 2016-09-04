package nu.annat.autohome;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nu.annat.autohome.api.Sensor;
import nu.annat.autohome.api.SensorList;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import nu.annat.autohome.databinding.SensorRowBinding;
import nu.annat.autohome.databinding.SwitchRowBinding;

public class ItemsAdapter extends RecyclerView.Adapter<SwitchViewHolder> {

	private LayoutInflater inflater;
	private List<Unit> data = new ArrayList<>();

	public ItemsAdapter(List<Unit> sensors) {
		data = sensors;
	}

	@Override
	public SwitchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		inflater = LayoutInflater.from(parent.getContext());
		SwitchRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.switch_row, parent, false);
		return new SwitchViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(SwitchViewHolder holder, int position) {
		holder.setData((SwitchUnit) data.get(position));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}
