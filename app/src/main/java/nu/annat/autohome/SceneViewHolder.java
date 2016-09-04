package nu.annat.autohome;

import android.view.View;
import android.widget.TextView;

import nu.annat.autohome.api.Scene;
import nu.annat.autohome.databinding.SceneRowBinding;
import nu.annat.autohome.rest.Server;

public class SceneViewHolder extends BaseViewHolder<Scene, SceneRowBinding> {


	public SceneViewHolder(SceneRowBinding binding) {
		super(binding);
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
//		super.setData(scene);
//		name.setText(scene.name);
	}
}
