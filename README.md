# Pie Chart for Android

## Description
A basic Pie Chart library that allows you to supply an adapter to the PieChartView and configure each pie slice.
There is also support for an expandable pie chart, showing a sub pie chart.  The Pie Chart will snap to whichever
compass direction you would like.  It is rotatable via touch or you can click on each slice to have it snap to the
anchor position.

## Usage

Here is a some sample code to create the initialize an adapter and set it to the chart:

```java
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
```

In the adapter you will have to provide the percentage of each slice as well as apply color and offset:

```java
	@Override
	public PieSliceDrawable getSlice(PieChartView parent, PieSliceDrawable convertDrawable, int position, float offset) {

		PieSliceDrawable sliceView = convertDrawable;
		
		if (sliceView == null) {
			sliceView = new PieSliceDrawable(parent, mContext);
		}
		
		// REQUIRED fields to set
		sliceView.setSliceColor(UiUtils.getRandomColor(mContext, position));
		sliceView.setPercent(mObjects.get(position));
		sliceView.setDegreeOffset(offset);
		
		return sliceView;
	}
```

An example of the xml layout file:

```xml
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:background="#FFF" >
			
		<com.saulpower.piechart.views.PieChartView
			android:id="@+id/chart"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:layout_centerInParent="true"
			android:layout_margin="10dp" />
			
	</RelativeLayout>
```

## License

(The MIT License)
	
	Copyright (c) 2013 Saul Howard
	
	Permission is hereby granted, free of charge, to any person obtaining a copy of
	this software and associated documentation files (the 'Software'), to deal in
	the Software without restriction, including without limitation the rights to use,
	copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
	Software, and to permit persons to whom the Software is furnished to do so,
	subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
	FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
	COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
	IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
	CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	 
