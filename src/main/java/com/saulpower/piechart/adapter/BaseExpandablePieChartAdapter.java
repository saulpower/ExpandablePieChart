package com.saulpower.piechart.adapter;

import com.saulpower.piechart.views.InfoDrawable;
import com.saulpower.piechart.views.PieChartView;
import com.saulpower.piechart.views.PieSliceDrawable;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public abstract class BaseExpandablePieChartAdapter extends BaseExpandableListAdapter {

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		throw new RuntimeException("No child view required");
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		throw new RuntimeException("No group view required");
	}
	
	public abstract PieSliceDrawable getChildSlice(PieChartView parent, PieSliceDrawable convertDrawable, int groupPosition, int childPosition, float offset);
	public abstract PieSliceDrawable getGroupSlice(PieChartView parent, PieSliceDrawable convertDrawable, int groupPosition, float offset);

	public abstract void configureGroupInfo(InfoDrawable info, PieSliceDrawable slice, int groupPosition);
	public abstract void configureChildInfo(InfoDrawable info, PieSliceDrawable slice, int groupPosition, int childPosition);
	
	public abstract float getChildAmount(int groupPosition, int childPosition);
	public abstract float getGroupAmount(int groupPosition);
	
	public abstract int getChildColor(int groupPosition, int childPosition);
	public abstract int getGroupColor(int groupPosition);
}
