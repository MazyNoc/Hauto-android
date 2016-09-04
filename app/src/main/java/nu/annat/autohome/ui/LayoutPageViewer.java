package nu.annat.autohome.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nu.annat.autohome.ItemsAdapter;
import nu.annat.autohome.R;
import nu.annat.autohome.Storage;
import nu.annat.autohome.api.All;
import nu.annat.autohome.api.Layout;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayoutPageViewer extends PagerAdapter {

	private static class ViewAndData {
		public View view;
		public Layout layout;
		public LayoutAdapter adapter;

		public ViewAndData(ViewGroup viewGroup, Layout layout) {
			this.view = viewGroup;
			this.layout = layout;
		}
	}

	private List<ViewAndData> items = new ArrayList<>();

	public LayoutPageViewer(ViewPager pager, LayoutInflater inflater, All all) {

		items = new ArrayList<>();
		for (Layout layout : all.layouts) {
			ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.layout_master, pager, false);
			RecyclerView content = (RecyclerView) viewGroup.findViewById(R.id.content);
			content.setLayoutManager(new GridLayoutManager(null, 3));

			content.setAdapter(new ItemsAdapter(
				getSensors(layout.unitIds)
			));
			items.add(new ViewAndData(viewGroup, layout));

		}

//		items = all.layouts.stream().map(layout -> {
//			ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.layout_master, pager, false);
//			RecyclerView content = (RecyclerView) viewGroup.findViewById(R.id.content);
//			content.setLayoutManager(new GridLayoutManager(null, 2));
//			content.setAdapter(new ItemsAdapter(
//				layout.unitIds.stream().map(s ->  Storage.getInstance().getSensorId(s)).collect(Collectors.toList())
//			));
//			return new ViewAndData(viewGroup, layout);
//		}).collect(Collectors.toList());
	}

	private List<Unit> getSensors(List<String> unitIds) {
		List<Unit> result= new ArrayList<>(unitIds.size());
		for (String unitId : unitIds) {
			result.add( Storage.getInstance().getSensorId(unitId));
		}
		return result;
	}

	public void changeSensor(SwitchUnit sensor, boolean b) {
		sensor.setOn( b);
		Server.getInstance().getService().executeSwitchOutlet(sensor.id, sensor.isOn()?"start":"stop").enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {

			}
		});
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return items.get(position).layout.name;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ViewAndData viewAndData = items.get(position);
		container.addView(viewAndData.view);
		return viewAndData;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(((ViewAndData) object).view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return ((ViewAndData) object).view.equals(view);
	}
}
