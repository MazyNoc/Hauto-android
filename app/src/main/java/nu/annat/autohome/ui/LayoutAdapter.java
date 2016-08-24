package nu.annat.autohome.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nu.annat.autohome.R;
import nu.annat.autohome.api.Unit;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutViewHolder> {

	List<Unit> items = new ArrayList<>();

	@Override
	public LayoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_switch, parent, false);
		return new LayoutViewHolder(inflate);
	}

	@Override
	public void onBindViewHolder(LayoutViewHolder holder, int position) {
		holder.setData(items.get(position));
	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
