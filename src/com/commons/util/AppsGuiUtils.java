package com.commons.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public abstract class AppsGuiUtils {

	/**
	 * Empty Constructor
	 */
	private AppsGuiUtils() {
	}

	public static SpannableString getTitleSpannable(String title) {

		SpannableString spannable = new SpannableString(title);

		return spannable;

	}

	public static void showToastShort(Context context, String message) {

		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.show();

	}

	public static void showToastLong(Context context, String message) {

		Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
		toast.show();

	}

	public static void addButtonEffectClick(final int color, Button btn) {

		btn.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					v.getBackground().setColorFilter(color,
							PorterDuff.Mode.SRC_ATOP);
					v.invalidate();
					break;
				}
				case MotionEvent.ACTION_UP: {
					v.getBackground().clearColorFilter();
					v.invalidate();
					break;
				}
				case MotionEvent.ACTION_CANCEL: {
					v.getBackground().clearColorFilter();
					v.invalidate();
					break;
				}
				}
				return Boolean.FALSE;
			}
		});

	}

	/**
	 * resize de image with the new valuess
	 * 
	 * @param ctx
	 *            Context of application
	 * @param resId
	 *            Id of the image
	 * @param w
	 *            New width of the image
	 * @param h
	 *            New height of the image
	 * @return
	 */
	public static Drawable resizeImage(Context ctx, int resId, int w, int h) {

		// load the original image
		Bitmap BitmapOrg = BitmapFactory.decodeResource(ctx.getResources(),
				resId);

		int width = BitmapOrg.getWidth();
		int height = BitmapOrg.getHeight();
		int newWidth = w;
		int newHeight = h;

		// calculate the scaling of the destination image
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// to manipulate the image we create an Matrix

		Matrix matrix = new Matrix();
		// resize the Bitmap
		matrix.postScale(scaleWidth, scaleHeight);

		// we recreate the image with the new values
		Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
				height, matrix, true);

		// if we want to show our image we need to create a drawable object so
		// assign it to a button, imageview ...
		return new BitmapDrawable(resizedBitmap);

	}

	/**
	 * resize de image with the new valuess
	 * 
	 * @param ctx
	 *            Context of application
	 * @param resId
	 *            Id of the image
	 * @param w
	 *            New width of the image
	 * @param h
	 *            New height of the image
	 * @return
	 */
	public static Drawable resizeImage(Drawable drawable, int w, int h) {

		Bitmap b = ((BitmapDrawable) drawable).getBitmap();
		Bitmap bitmapResized = Bitmap.createScaledBitmap(b, w, h, false);
		return new BitmapDrawable(bitmapResized);

	}
	
	

}
