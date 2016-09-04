package nu.annat.autohome;

import android.databinding.DataBindingUtil;
import android.databinding.repacked.org.antlr.v4.runtime.misc.IntegerList;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import nu.annat.autohome.api.All;
import nu.annat.autohome.databinding.ActivityMainBinding;
import nu.annat.autohome.rest.Api;
import nu.annat.autohome.rest.Server;
import nu.annat.autohome.ui.LayoutPageViewer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private MainActivityPresenter presenter;
	private Api service;
	private ActivityMainBinding binding;
	private Integer currentPage=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		//presenter = new MainActivityPresenter(this);

		service = Server.getInstance().getService();
		if(savedInstanceState!=null){
			currentPage = savedInstanceState.getInt("page");
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		refresh();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("page", binding.viewpager.getCurrentItem());
	}

	private void refresh() {
		service.getAll().enqueue(new Callback<All>() {
			@Override
			public void onResponse(Call<All> call, Response<All> response) {
				updateData(response.body());
			}

			@Override
			public void onFailure(Call<All> call, Throwable t) {

			}
		});
	}

	private void updateData(All body) {

		Storage.getInstance().addSensors(body.units);

		ViewPager viewpager = binding.viewpager;
		TabLayout tabLayout = binding.tabLayout;

		tabLayout.setupWithViewPager(viewpager, true);

		LayoutPageViewer layoutPageViewer = new LayoutPageViewer(viewpager, LayoutInflater.from(viewpager.getContext()), body);

		int currentItem = currentPage!=null?currentPage:viewpager.getCurrentItem();
		viewpager.setAdapter(layoutPageViewer);
		viewpager.setCurrentItem(currentItem);
		currentPage = null;

//
//		Layout layout = body.layouts.get(0);
//		LayoutWorker layoutWorker = new LayoutWorker();
//		new LayoutPresenter(findViewById(R.id.root), layout, layoutWorker);

		//presenter.setData(sensors);
		//presenter.setData2(body.scenes);
	}
}
