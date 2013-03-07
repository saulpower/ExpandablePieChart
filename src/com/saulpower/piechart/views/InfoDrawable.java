package com.saulpower.piechart.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.saulpower.piechart.R;
import com.saulpower.piechart.views.ThreadAnimator.AnimationListener;

/**
 * 
 * @author Saul Howard
 *
 */
public class InfoDrawable extends Drawable {
    
    public final String TAG = this.getClass().getSimpleName();
	
    private PieChartView mChart;
    
	private Paint mTitlePaint, mAmountPaint, mSubTitlePaint;
	private float mOffsetX;
	private float mRadius;
	
	private Rect mTitleBounds = new Rect();
	private Rect mAmountBounds = new Rect();
	private Rect mSubTitleBounds = new Rect();
	
	private PointF mTitlePoint = new PointF();
	private PointF mAmountPoint = new PointF();
	private PointF mSubTitlePoint = new PointF();
	
	private float mTitleOffset, mSubTitleOffset;
	
	private String mTitle = "", mAmount = "", mSubTitle = "";

	public float getOffsetX() {
		return mOffsetX;
	}

	public void setOffsetX(float mOffsetX) {
		this.mOffsetX = mOffsetX;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
		mTitlePaint.getTextBounds(mTitle, 0, mTitle.length(), mTitleBounds);
		mTitlePoint.x = getBounds().exactCenterX() - mTitleBounds.width() / 2;
		mTitlePoint.y = getBounds().exactCenterY() + mTitleOffset;
	}

	public String getAmount() {
		return mAmount;
	}

	public void setAmount(String mAmount) {
		this.mAmount = mAmount;
		mAmountPaint.getTextBounds(mAmount, 0, mAmount.length(), mAmountBounds);
		mAmountPoint.x = getBounds().exactCenterX() - mAmountBounds.width() / 2;
		mAmountPoint.y = getBounds().exactCenterY() + mAmountBounds.height() / 2;
	}

	public String getSubTitle() {
		return mSubTitle;
	}

	public void setSubTitle(String mSubTitle) {
		this.mSubTitle = mSubTitle;
		mSubTitlePaint.getTextBounds(mSubTitle, 0, mSubTitle.length(), mSubTitleBounds);
		mSubTitlePoint.x = getBounds().exactCenterX() - mSubTitleBounds.width() / 2;
		mSubTitlePoint.y = getBounds().exactCenterY() + mSubTitleBounds.height() + mSubTitleOffset;
	}

	public void setAmountColor(int color) {
		mAmountPaint.setColor(color);
		invalidateSelf();
	}
	
	public InfoDrawable(PieChartView chart, Context context, Rect bounds, float radius) {
		
		mChart = chart;
		Resources resources = context.getResources();
		setBounds(bounds);
		mRadius = radius;
		
		mTitleOffset = -0.8f * radius / 3;
		mSubTitleOffset = radius / 3;
		
		mTitlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTitlePaint.setColor(resources.getColor(R.color.gray4));
		mTitlePaint.setTextSize(mRadius / 9);
		
		mAmountPaint = new Paint(mTitlePaint);
		mAmountPaint.setTextSize(mRadius / 5);
		mAmountPaint.setShadowLayer(1.0f, 1.0f, 1.0f, resources.getColor(R.color.gray7));
		
		mSubTitlePaint = new Paint(mTitlePaint);
		mSubTitlePaint.setColor(resources.getColor(R.color.gray3));
		
	}
	
	public void animateTransition(final String amount, final int amountColor, final String title) {
		
		if (mChart.getDrawThread().isPaused()) {
			
			setAmount(amount);
			setAmountColor(amountColor);
			setTitle(title);
			
			return;
		}
		
		final ThreadAnimator inAlpha = ThreadAnimator.ofInt(0, 255);
		inAlpha.setDuration(200);
		
		ThreadAnimator outAlpha = ThreadAnimator.ofInt(255, 0);
		outAlpha.setDuration(200);
		outAlpha.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationEnded() {
				setAmount(amount);
				setAmountColor(amountColor);
				setTitle(title);
				mChart.getDrawThread().setInfoAnimator(inAlpha);
			}
		});
		
		mChart.getDrawThread().setInfoAnimator(outAlpha);
	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawText(mTitle, mTitlePoint.x, mTitlePoint.y, mTitlePaint);
		canvas.drawText(mAmount, mAmountPoint.x, mAmountPoint.y, mAmountPaint);
		
		canvas.drawText(mSubTitle, mSubTitlePoint.x, mSubTitlePoint.y, mSubTitlePaint);
	}

	@Override
	public int getOpacity() {
		return 0;
	}

	@Override
	public void setAlpha(int alpha) {
		
		mAmountPaint.setAlpha(alpha);
		mTitlePaint.setAlpha(alpha);
		invalidateSelf();
	}

	@Override
	public void setColorFilter(ColorFilter cf) {}

}
