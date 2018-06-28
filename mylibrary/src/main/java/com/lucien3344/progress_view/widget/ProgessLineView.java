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
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by lsh_2012@qq.com
 * on 2018/6/27
 * <p>
 * 线性进度条
 */

public class ProgessLineView extends View {


    private Paint paint;// 画笔
    private RectF rectF;

    private int bmColor;// 底部横线颜色
    private float bmHight;// 底部横线高度
    private int color;// 进度条颜色
    private float hight;// 进度条高度


    private int TextColor;//
    private float TextSize;// 进度条高度
    private String progressText;// 进度条颜色


    private int RTextColor;
    private float RTextSize;
    private String RprogressText;

    protected float progress;

    public void setColor(int color) {
        this.color = color;
    }

    public ProgessLineView(Context context) {
        this(context, null);
    }

    public ProgessLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgessLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        paint = new Paint();
        rectF = new RectF();
        TypedArray mTypedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProgessLineView, defStyleAttr, 0);

        bmColor = mTypedArray.getColor(R.styleable.ProgessLineView_ProgressLine_bmColor, Color.GRAY);
        bmHight = mTypedArray.getDimensionPixelSize(R.styleable.ProgessLineView_ProgressLine_bmHight, 2);
        color = mTypedArray.getColor(R.styleable.ProgessLineView_ProgressLine_color, Color.BLUE);
        hight = mTypedArray.getDimensionPixelSize(R.styleable.ProgessLineView_ProgressLine_hight, 2);
        TextColor = mTypedArray.getColor(R.styleable.ProgessLineView_ProgressLine_TextColor, Color.BLUE);
        TextSize = mTypedArray.getDimensionPixelSize(R.styleable.ProgessLineView_ProgressLine_TextSize, 15);
        progressText = mTypedArray.getString(R.styleable.ProgessLineView_ProgressLine_Text);
        RTextColor = mTypedArray.getColor(R.styleable.ProgessLineView_ProgressLine_RTextColor, Color.BLUE);
        RTextSize = mTypedArray.getDimensionPixelSize(R.styleable.ProgessLineView_ProgressLine_RTextSize, 15);
        RprogressText = mTypedArray.getString(R.styleable.ProgessLineView_ProgressLine_RText);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor(bmColor);
        paint.setStrokeCap(Paint.Cap.SQUARE);// 圆角
        // paint.setStyle(Paint.Style.FILL); // 设置实心
        paint.setStrokeWidth(bmHight); // 设置笔画的宽度
        paint.setAntiAlias(true); // 消除锯齿
        canvas.drawRoundRect(0, getHeight() - bmHight, getWidth(), getHeight(), bmHight / 2, bmHight / 2, paint);
//        rectF.set(0, 0, getWidth(), bmHight);
//        canvas.drawRect(0, getHeight() - bmHight, getWidth(), getHeight(), paint);

        paint.setColor(color);
        paint.setStrokeWidth(hight); // 设置笔画的宽度
        //矩形
        canvas.drawRoundRect(0, getHeight() - bmHight, progress, getHeight(), bmHight / 2, bmHight / 2, paint);
//        rectF.set(0, 0, progress, bmHight);
//        canvas.drawRect(0, getHeight() - bmHight, progress, getHeight(), paint);
        paint.setStrokeWidth(0);
        paint.setColor(TextColor);
        paint.setTextSize(TextSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
        canvas.drawText(progressText + "", 0, getHeight() - bmHight - 15, paint);

        paint.setStrokeWidth(0);
        paint.setColor(RTextColor);
        paint.setTextSize(RTextSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
        float textWidth = paint.measureText(RprogressText + "");
        canvas.drawText(RprogressText + "", getWidth() - textWidth, getHeight() - bmHight - 15, paint);
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
        this.progress = progress * getWidth() / 100;
        invalidate();
    }

    /**
     * 赋值+执行动画
     *
     * @param progressTitle     进度标题 string
     * @param progress     进度 float
     * @param RprogressText 单位  string
     */
    public void setDoProgress(String progressTitle, float progress, String RprogressText) {
        this.progress = progress * getWidth() / 100;
        this.progressText = progressTitle;
        this.RprogressText = progress + RprogressText;
        AnimatorSet animation = new AnimatorSet();
        ObjectAnimator progressAnimation = ObjectAnimator.ofFloat(this, "progress", 0f, progress);
        progressAnimation.setDuration(500);//动画耗时
        progressAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        animation.playTogether(progressAnimation);
        animation.start();
        invalidate();
    }

    /**
     * 赋值
     *
     * @param progress 进度 float
     */
    public void setProgress(String progressTitle, float progress, String RprogressText) {
        this.progress = progress * getWidth() / 100;
        this.progressText = progressTitle;
        this.RprogressText = progress + RprogressText;
        invalidate();
    }
}
