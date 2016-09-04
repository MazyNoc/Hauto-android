package nu.annat.autohome;

import android.view.View;

public abstract class BasePresenter<WORKER extends BaseWorker> {
	protected final View root;
	protected final WORKER worker;

	public BasePresenter(View root, WORKER worker) {
		this.root = root;
		this.worker = worker;
	}

	protected abstract void prepare();
}
