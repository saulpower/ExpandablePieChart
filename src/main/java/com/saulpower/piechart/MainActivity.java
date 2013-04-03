package com.saulpower.piechart;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.saulpower.piechart.adapter.PieChartAdapter;
import com.saulpower.piechart.extra.Dynamics;
import com.saulpower.piechart.extra.FrictionDynamics;
import com.saulpower.piechart.views.PieChartView;
import com.saulpower.piechart.views.PieChartView.PieChartAnchor;

public class MainActivity extends Activity {

	private PieChartView mChart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    	
		setContentView(R.layout.activity_main);
		
		List<Float> slices = new ArrayList<Float>();
		
		slices.add(0.25f);
		slices.add(0.05f);
		slices.add(0.1f);
		slices.add(0.05f);
		slices.add(0.2f);
		slices.add(0.3f);
		slices.add(0.05f);
		
		PieChartAdapter adapter = new PieChartAdapter(this, slices);
		
		mChart = (PieChartView) findViewById(R.id.chart);
		mChart.setDynamics(new FrictionDynamics(0.95f));
		mChart.setSnapToAnchor(PieChartAnchor.BOTTOM);
		mChart.setAdapter(adapter);
		mChart.onResume();
	}
	
    /**
     * A very simple dynamics implementation with spring-like behavior
     */
    class SimpleDynamics extends Dynamics {

        /** The friction factor */
        private float mFrictionFactor;

        /**
         * Creates a SimpleDynamics object
         * 
         * @param frictionFactor The friction factor. Should be between 0 and 1.
         *            A higher number means a slower dissipating speed.
         * @param snapToFactor The snap to factor. Should be between 0 and 1. A
         *            higher number means a stronger snap.
         */
        public SimpleDynamics(final float frictionFactor) {
            mFrictionFactor = frictionFactor;
        }

        @Override
        protected void onUpdate(final int dt) {

            // then update the position based on the current velocity
            mPosition += mVelocity * dt / 1000;

            // and finally, apply some friction to slow it down
            mVelocity *= mFrictionFactor;
        }
    }

}
