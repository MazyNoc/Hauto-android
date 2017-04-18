package nu.annat.autohome;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nu.annat.autohome.api.Scene;
import nu.annat.autohome.databinding.SceneRowBinding;

public class ScenesAdapter extends RecyclerView.Adapter<SceneViewHolder> {

	private final LayoutInflater inflater;
	private List<Scene> data = new ArrayList<>();

	public ScenesAdapter(MainActivity activity, List<Scene> scenes) {
		inflater = LayoutInflater.from(activity);
		data = scenes;
	}

	@Override
	public SceneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		SceneRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.sensor_row, parent, false);
		return new SceneViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(SceneViewHolder holder, int position) {
		holder.setData(data.get(position));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}
