package nu.annat.autohome;

import android.view.View;

import nu.annat.autohome.api.Scene;
import nu.annat.autohome.api.UnitCommand;
import nu.annat.autohome.api.UnitCommandList;
import nu.annat.autohome.databinding.SceneRowBinding;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SceneViewHolder extends BaseViewHolder<Scene, SceneRowBinding> {


    public SceneViewHolder(SceneRowBinding binding) {
        super(binding);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Server.getInstance().getService()
                    .execute(new UnitCommandList(new UnitCommand(data.id, data.createCommand())))
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                        }
                    });
            }
        });
    }

//	public vpoid old(View itemView) {
//		name = (TextView) itemView.findViewById(R.id.name);
//		final String id = this.data.id;
//		itemView.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Server.getInstance().getService().executeScene(id);
//			}
//		});
//	}

    @Override
    public void setData(Scene scene) {
        super.setData(scene);
        binding.setPresenter(data);
        binding.executePendingBindings();
//		super.setData(scene);
//		name.setText(scene.name);
    }
}
