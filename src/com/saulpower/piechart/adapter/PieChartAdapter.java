package com.saulpower.piechart.adapter;

import java.util.List;

import android.content.Context;

import com.saulpower.piechart.extra.UiUtils;
import com.saulpower.piechart.views.PieChartView;
import com.saulpower.piechart.views.PieSliceDrawable;

public class PieChartAdapter extends BasePieChartAdapter {
    
    public final String TAG = this.getClass().getSimpleName();

	private Context mContext;
	private List<Float> mObjects;
	
	public PieChartAdapter(Context context, List<Float> objects) {
		init(context, objects);
	}
	
	@Override
	public int getCount() {
		return mObjects.size();
	}

	@Override
	public Object getItem(int position) {
		return mObjects.get(position);
	}
	
	private void init(Context context, List<Float> objects) {
		
		mContext = context;
		mObjects = objects;
	}

	@Override
	public float getPercent(int position) {
		Float percent = (Float) getItem(position);
		
		return percent;
	}

	@Override
	public PieSliceDrawable getSlice(PieChartView parent, PieSliceDrawable convertDrawable, int position, float offset) {

		PieSliceDrawable sliceView = convertDrawable;
		
		if (sliceView == null) {
			sliceView = new PieSliceDrawable(parent, mContext);
		}
		
		sliceView.setSliceColor(UiUtils.getRandomColor(mContext, position));
		sliceView.setPercent(mObjects.get(position));
		sliceView.setDegreeOffset(offset);
		
		return sliceView;
	}
}
