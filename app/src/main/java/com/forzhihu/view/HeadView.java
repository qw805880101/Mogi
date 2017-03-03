package com.forzhihu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.forzhihu.R;

/**
 * Created by tc on 2017/2/28.
 */

public class HeadView extends ImageView {

    private Paint mPaint;

    private int mViewWidth, mViewHeight;// 控件宽高

    private int colorID = R.color.color_2a982f;

    private boolean isAddState = false;


    //基本的三个构造函数
    public HeadView(Context context) {
        super(context);
        initPaint();
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public HeadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
    }

    public void addState(boolean isAddState) {
        this.isAddState = isAddState;
    }

    //自定义View实现过程中很重要的onDraw绘制图形的方法
    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        //空值判断，必要步骤，避免由于没有设置src导致的异常错误
        if (drawable == null) {
            return;
        }

        //必要步骤，避免由于初始化之前导致的异常错误
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        if (!(drawable instanceof BitmapDrawable)) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();

        if (null == b) {
            return;
        }

        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth();

        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);
        canvas.save();

        if (isAddState) {
            int radius = roundBitmap.getWidth();
            System.out.println("radius = " + radius);
            mPaint.setColor(this.getResources().getColor(R.color.color_232627));
            float start_x = radius * (float) Math.cos(Math.PI / 180 * 7.5 * 6);
            float start_y = radius * (float) Math.sin(Math.PI / 180 * 7.5 * 6);

            start_x += Math.abs((mViewWidth - radius) / 4);
            start_y += Math.abs((mViewWidth - radius) / 4);
            float chRadius = Math.abs((mViewWidth - radius) / 4) + 5;

            canvas.drawCircle(start_x, start_y, chRadius, mPaint);
            canvas.save();

            mPaint.setColor(this.getResources().getColor(colorID));
            canvas.drawCircle(start_x, start_y, chRadius - 10, mPaint);
            canvas.save();
        }
    }

    /**
     * 初始Bitmap对象的缩放裁剪过程
     *
     * @param bmp    初始Bitmap对象
     * @param radius 圆形图片直径大小
     * @return 返回一个圆形的缩放裁剪过后的Bitmap对象
     */
    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        //比较初始Bitmap宽高和给定的圆形直径，判断是否需要缩放裁剪Bitmap对象
        if (bmp.getWidth() != radius || bmp.getHeight() != radius)
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        else
            sbmp = bmp;
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f,
                sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0.1f, paint);
        //核心部分，设置两张图片的相交模式，在这里就是上面绘制的Circle和下面绘制的Bitmap
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setViewW(int w) {
        mViewWidth = w;
    }

    public void setColor(int colorID) {
        this.colorID = colorID;
    }

}