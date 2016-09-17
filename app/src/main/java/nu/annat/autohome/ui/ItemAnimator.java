package nu.annat.autohome.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

public class ItemAnimator extends DefaultItemAnimator {

	@Override
	public boolean animateAdd(RecyclerView.ViewHolder holder) {
		return super.animateAdd(holder);
	}

	@Override
	public long getAddDuration() {
		return 5000;
	}

	@Override
	public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
		return super.animateAppearance(viewHolder, preLayoutInfo, postLayoutInfo);
	}

	@Override
	public void onAddStarting(RecyclerView.ViewHolder item) {
		super.onAddStarting(item);
		item.itemView.setTranslationY(100);
		item.itemView.animate().translationY(0);
	}
}
