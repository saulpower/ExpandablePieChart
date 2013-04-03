package com.saulpower.piechart.extra;


import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

public class UiUtils {

    public static int getScreenWidth (Activity activity) {
           final DisplayMetrics metrics = getDisplayMetrics(activity);

           return metrics.widthPixels;
       }

    public static int getScreenHeight (Activity activity) {
           final DisplayMetrics metrics = getDisplayMetrics(activity);

           return metrics.heightPixels;
       }

    public static int getMinimumPanalWidth (final Activity activity) {
        double ratio = getDensityRatio(activity);
        return Math.max(Math.min(getScreenWidth(activity), getScreenHeight(activity)) / 5, (int)(170 * ratio));
    }
    
    public static int getMinimumPanalHeight (final Activity activity) {
        return getScreenHeight(activity);
    }

    public static float getDensityRatio (final Context context) {
        final DisplayMetrics metrics = getDisplayMetrics(context);
        return (metrics.densityDpi / Constant.STANDARD_DPI);
    }
    
    /**
     * This method convets dp unit to equivalent device specific value in pixels. 
     * 
     * @param dp      -- A value in dp. Which we need to convert into pixels
     * @param context -- Context to get resources and device specific display metrics
     * @return A float value to represent Pixels equivalent to dp according to device
     */
    public static float convertDpToPixel(float dp, Context context){
        float px = dp * getDensityRatio(context);
        return px;
    }
    
    /**
     * This method converts device specific pixels to device independent pixels.
     * 
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return An int value to represent dp equivalent of px value
     */
    public static int convertPixelsToDp(float px,Context context) {
    	
        DisplayMetrics metrics = getDisplayMetrics(context);
        int dp = (int) (px / metrics.density + 0.5);
        
        return dp;

    }

    /**
     * Returns the width and height measurement in pixels.
     * 
     * @return
     */
	public static float[] getScreenMeasurements(Context context) {
		
		float[] values = new float[2];
		
        final DisplayMetrics metrics = getDisplayMetrics(context);
        
        values[0] = metrics.widthPixels;
        values[1] = metrics.heightPixels;
        
        return values;
	}
   
    public static float getDynamicPixels(Context context, float pixels) {
    	return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixels, context.getResources().getDisplayMetrics());
    }
    
    public static float getScaledPixels(Context context, float size) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, context.getResources().getDisplayMetrics());
    }
    
    public static DisplayMetrics getDisplayMetrics(Context context) {

        final DisplayMetrics metrics = new DisplayMetrics();
        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        
        return metrics;
    }

	public static int getRandomColor(Context context, int position) {
		
		position = position > 15 ? position % 16 : position;
		
		return context.getResources().getColor(Constant.RANDOM_COLORS[position]);
	}
}
