package nu.annat.autohome.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class RippleCard extends FrameLayout implements View.OnClickListener {
	private static final String TAG = RippleCard.class.getName();
	PointF lastPoint = new PointF();
	private boolean on;
	private ColorMatrixColorFilter colorMatrixColorFilter;
	private Bitmap image;
	private OnClickListener clickListener;

	public RippleCard(Context context) {
		super(context);
	}

	public RippleCard(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RippleCard(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public RippleCard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public void onClick(View view) {
		toggle();
		if (clickListener != null) {
			clickListener.onClick(this);
		}
	}

	@Override
	public void setOnClickListener(OnClickListener l) {
		this.clickListener = l;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		lastPoint.set(event.getX(), event.getY());
		return super.onTouchEvent(event);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		ColorMatrix saturationMatrix = new ColorMatrix();
		saturationMatrix.setSaturation(0);

		ColorMatrix scaleMatrix = new ColorMatrix();
		float scale = 0.5f;
		scaleMatrix.setScale(scale, scale, scale, 1f);

		scaleMatrix.postConcat(saturationMatrix);

		colorMatrixColorFilter = new ColorMatrixColorFilter(scaleMatrix);

		ImageView imageView = new ImageView(getContext());
		addView(imageView);

		super.setOnClickListener(this);
	}

	public void setImage(Bitmap image) {
		this.image = image;
		if (getChildCount() > 0) {
			((ImageView) getChildAt(0)).setImageBitmap(image);
			setState(on);
		}
	}

	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		return layoutParams;
	}

	public boolean isOn() {
		return on;
	}

	public void setState(boolean state) {
		on = state;
		prepareView((ImageView) getChildAt(0));
	}

	private void prepareView(ImageView imageView) {
		if (image == null) {
			imageView.setImageDrawable(new ColorDrawable(on ? 0xff082332 : 0x000000));
		} else {
			imageView.setImageBitmap(image);
			imageView.setColorFilter(on ? null : colorMatrixColorFilter);
		}
	}

	@Override
	public void addView(View child) {
		super.addView(child);
	}

	private void toggle() {
		on = !on;
		ImageView imageView = new ImageView(getContext());
		addView(imageView);
		prepareView(imageView);

		//setState(on);
		Animator circularReveal = ViewAnimationUtils.createCircularReveal(imageView, (int) lastPoint.x, (int) lastPoint.y, 0, getWidth() * 1.4f);

		circularReveal.setDuration(300);
		circularReveal.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animator) {

			}

			@Override
			public void onAnimationEnd(Animator animator) {
				if (getChildCount() > 1) {
					removeViewAt(0);
				}
			}

			@Override
			public void onAnimationCancel(Animator animator) {

			}

			@Override
			public void onAnimationRepeat(Animator animator) {

			}
		});
		circularReveal.start();
	}
}
