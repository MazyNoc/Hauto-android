package nu.annat.autohome;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import nu.annat.autohome.api.DimmerSwitchUnit;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import nu.annat.autohome.databinding.DimmerSwitchRowBinding;
import nu.annat.autohome.databinding.SwitchRowBinding;

public class ItemsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

	private final boolean useAnims;
	private LayoutInflater inflater;
	private List<Unit> data = new ArrayList<>();
	private int lastPosition = -1;

	public ItemsAdapter(List<Unit> sensors, boolean useAnims) {
		data = sensors;
		this.useAnims = useAnims && false;
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		inflater = LayoutInflater.from(parent.getContext());
		if (viewType == R.layout.dimmer_switch_row) {
			DimmerSwitchRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.dimmer_switch_row, parent, false);
			return new DimmerSwitchViewHolder(binding);
		} else {
			SwitchRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.switch_row, parent, false);
			return new SwitchViewHolder(binding);
		}
	}

	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		holder.setData(data.get(position));
		if (useAnims) setAnimation(holder);
	}

	@Override
	public int getItemViewType(int position) {
		Unit unit = data.get(position);
		if (unit instanceof DimmerSwitchUnit) {
			return R.layout.dimmer_switch_row;
		} else if (unit instanceof SwitchUnit) {
			return R.layout.switch_row;
		}
		return R.layout.switch_row;
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	private void setAnimation(RecyclerView.ViewHolder holder) {
		// If the bound view wasn't previously displayed on screen, it's animated
		if (holder.getAdapterPosition() > lastPosition) {
			Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slide_up);
			animation.setInterpolator(new DecelerateInterpolator(1f));
			animation.setStartOffset(holder.getAdapterPosition() * 50);
			holder.itemView.startAnimation(animation);
			lastPosition = holder.getAdapterPosition();
		}
	}
}
