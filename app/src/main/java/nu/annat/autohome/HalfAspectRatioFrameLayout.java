package nu.annat.autohome;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class HalfAspectRatioFrameLayout extends FrameLayout {
	public HalfAspectRatioFrameLayout(Context context) {
		super(context);
	}

	public HalfAspectRatioFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HalfAspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public HalfAspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int size = getMeasuredWidth();// Math.max(getMeasuredWidth(), getMeasuredHeight());
		int spec = MeasureSpec.makeMeasureSpec(size / 2, MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, spec);
	}
}
