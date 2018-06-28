package com.lucien3344.progress_view.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;


/**
 * Created by lsh_2012@qq.com
 * on 2018/6/27
 * <p>
 * 圆形进度View
 */

public class ProgressCircleView extends View {
    /*** 画笔对象的引用 */
    private Paint[] paints;
    RectF oval;
    /*** 圆环的颜色*/
    private int roundColor;
    /*** 圆环的宽度*/
    private float roundWidth;
    /*** 圆环进度的颜色*/
    private int roundProgressColor;
    /***中间的字**/
    private String progressText;
    /***中间的字体大小**/
    private int myRoundTextSize;
    /***中间的字体颜色**/
    private int myRoundTextColor;
    /***进度***/
    protected float progress;


    public ProgressCircleView(Context context) {
        this(context, null);
    }

    public ProgressCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        paints = new Paint[4];
        for (int i = 0; i < paints.length; i++) {
            paints[i] = new Paint();
        }
        oval = new RectF();
        TypedArray mTypedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProgressCircle, defStyleAttr, 0);
        roundColor = mTypedArray.getColor(R.styleable.ProgressCircle_RoundColor, Color.GRAY);
        roundWidth = mTypedArray.getDimension(R.styleable.ProgressCircle_RoundWidth, 3);
        roundProgressColor = mTypedArray.getColor(R.styleable.ProgressCircle_RoundProgressColor, Color.RED);
        progressText = mTypedArray.getString(R.styleable.ProgressCircle_RoundText);
        myRoundTextSize = mTypedArray.getDimensionPixelSize(R.styleable.ProgressCircle_RoundTextSize, 15);
        myRoundTextColor = mTypedArray.getColor(R.styleable.ProgressCircle_RoundProgressColor, Color.BLACK);
        mTypedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float centre = getWidth() / 2; // 获取圆心的x坐标
        float radius = (centre - roundWidth / 2); // 圆环的半径

        paints[0].setColor(roundColor); // 设置圆环的颜色
        paints[0].setStyle(Paint.Style.STROKE); // 设置空心
        paints[0].setStrokeWidth(roundWidth); // 设置圆环的宽度
        paints[0].setAntiAlias(true); // 消除锯齿
        paints[0].setStrokeCap(Paint.Cap.ROUND);// 圆角

        canvas.drawCircle(centre, centre, radius, paints[0]); // 画出圆环

        paints[0].setColor(roundProgressColor);
        // 用于定义的圆弧的形状和大小的界限.指定圆弧的外轮廓矩形区域
        // 椭圆的上下左右四个点(View 左上角为0)
        oval.set(centre - radius, centre - radius, centre + radius, centre + radius);

        //画圆弧
        canvas.drawArc(oval, -90, progress, false, paints[0]);

        /**
         * 画进中间的text
         */
        paints[0].setStrokeWidth(0);
        paints[0].setColor(myRoundTextColor);
        paints[0].setTextSize(myRoundTextSize);
        paints[0].setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
        float textWidth = paints[0].measureText(progressText + "");
        canvas.drawText(progressText + "", centre - textWidth / 2, centre + myRoundTextSize / 2, paints[0]); // 画出进度百分比
    }


    public float getProgress() {
        return progress;
    }
    /**
     * 赋值
     *
     * @param progress 进度 float
     */
    public void setProgress(float progress) {
        this.progress = progress * 360 / 100;
        invalidate();// UI thread
        // postInvalidate();//non-UI thread.
    }

    /**
     * 赋值+执行动画
     *
     * @param progress 进度 float
     * @param progressText 单位  string
     */
    public void setDoProgress(float progress, String progressText) {
        this.progressText = progress + progressText;
        this.progress = progress;
        //也可使用3.0的AnimationSet实现
//      AnimationSet set = new AnimationSet(true);
//      set.setRepeatCount(AnimationSet.INFINITE);
//      set.setInterpolator(new AccelerateDecelerateInterpolator());
//      set.start();
//      this.setAnimation(set);
        //4.0以上，在AnimationSet基础上封装的，遗憾的是没有Repeat
        AnimatorSet animation = new AnimatorSet();
        ObjectAnimator progressAnimation = ObjectAnimator.ofFloat(this, "progress", 0f, progress);
        progressAnimation.setDuration(500);// 动画执行时间
        progressAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.playTogether(progressAnimation);//动画同时执行,可以做多个动画
        animation.start();
        invalidate();// UI thread
    }
}
