package nu.annat.autohome;

import android.view.View;
import android.widget.TextView;

import nu.annat.autohome.api.Scene;
import nu.annat.autohome.rest.Server;

public class SceneViewHolder extends BaseViewHolder<Scene> {

	private final TextView name;

	public SceneViewHolder(View itemView) {
		super(itemView);
		name = (TextView) itemView.findViewById(R.id.name);
		itemView.setOnClickListener(view -> {
			Server.getInstance().getService().executeScene(data.id);
		});
	}

	@Override
	public void setData(Scene scene) {
		super.setData(scene);
		name.setText(scene.name);
	}
}
