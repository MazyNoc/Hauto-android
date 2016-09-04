package nu.annat.autohome;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class AspectRatioFrameLayout extends FrameLayout {
	public AspectRatioFrameLayout(Context context) {
		super(context);
	}

	public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int size = Math.max(getMeasuredWidth(), getMeasuredHeight());
		int spec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
		super.onMeasure(spec, spec);
	}
}
