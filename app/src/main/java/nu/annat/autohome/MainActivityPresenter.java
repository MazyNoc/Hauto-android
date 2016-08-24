package nu.annat.autohome;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import nu.annat.autohome.api.Scene;
import nu.annat.autohome.api.SensorList;

public class MainActivityPresenter {
	private final MainActivity activity;
	private final RecyclerView listView;

	public MainActivityPresenter(MainActivity mainActivity) {
		this.activity = mainActivity;
		this.listView = (RecyclerView) activity.findViewById(R.id.name);
		listView.setLayoutManager(new LinearLayoutManager(mainActivity));
	}

	public void setData(SensorList sensors){
		//listView.swapAdapter( new ItemsAdapter(sensors), true);
	}
	public void setData2(List<Scene> scenes){
		listView.swapAdapter( new ScenesAdapter(activity, scenes), true);
	}
}
