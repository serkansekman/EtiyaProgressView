package com.etiya.progressview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class EtiyaProgressView extends View {
    private int width, height;
    private Paint outerCirclePaint, innerCirclePaint, progressPaint, textPaint, percentagePaint;
    private int OUTER_STROKE_WIDTH = 2;
    private int INNER_STROKE_WIDTH = 4;
    private static int START_ANGLE = 270;
    private int innerCircleMargin = -1;
    private RectF progressBounds;
    private int innerRadius, outerRadius;
    private float progress = 0, maxProgress = 100, lastProgress = 0, progressUpdate;
    private ValueAnimator animator;
    private static String PERCENTAGE_TEXT = "%";
    private String progressText;


    public EtiyaProgressView(Context context) {
        super(context);
        init(context, null);
    }

    public EtiyaProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        outerCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outerCirclePaint.setStyle(Paint.Style.STROKE);
        int outerCircleColor = 0xFFdbecf8;
        outerCirclePaint.setColor(outerCircleColor);

        innerCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        innerCirclePaint.setStyle(Paint.Style.STROKE);
        int innerCircleColor = 0xFFdbecf8;
        innerCirclePaint.setColor(innerCircleColor);

        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setStyle(Paint.Style.STROKE);

        progressBounds = new RectF();

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int textColor = 0xFF81d4fa;
        textPaint.setColor(textColor);

        percentagePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        percentagePaint.setColor(textColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        outerCirclePaint.setStrokeWidth(OUTER_STROKE_WIDTH);
        innerCirclePaint.setStrokeWidth(INNER_STROKE_WIDTH);
        progressPaint.setStrokeWidth(INNER_STROKE_WIDTH);
        textPaint.setTextSize(height / 4);
        percentagePaint.setTextSize(height / 8);
        float textWidth = textPaint.measureText(progressText);
        canvas.drawCircle(width / 2, height / 2, outerRadius, outerCirclePaint);
        canvas.drawCircle(width / 2, height / 2, innerRadius, innerCirclePaint);
        canvas.drawArc(progressBounds, START_ANGLE, progressUpdate, false, progressPaint);
        canvas.drawText(PERCENTAGE_TEXT, 0, PERCENTAGE_TEXT.length(), (width / 2) - (textWidth / 2) + textWidth, height / 2 + 15, percentagePaint);
        canvas.drawText(progressText, 0, progressText.length(), (width / 2) - (textWidth / 2), height / 2 + 25, textPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 300;
        int desiredHeight = 300;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        OUTER_STROKE_WIDTH = (width / (width / 5));
        INNER_STROKE_WIDTH = (width / (width / 16));
        outerRadius = ((width / 2) - OUTER_STROKE_WIDTH);
        innerRadius = ((width / 2) - INNER_STROKE_WIDTH - innerCircleMargin);
        progressText = "0";
        //subText="";
        progressBounds.set(((width / 2) - (innerRadius)), ((height / 2) - (innerRadius)), ((width / 2) - INNER_STROKE_WIDTH - innerCircleMargin) + (width / 2), ((height / 2) - INNER_STROKE_WIDTH - innerCircleMargin) + (height / 2));
    }


    public void setProgress(int progress) {
        lastProgress = this.progress;
        this.progress = progress;
        post(new Runnable() {
            @Override
            public void run() {
                float incr = 360 / maxProgress;
                Log.e("pogress", "last:" + lastProgress + ",progress:" + EtiyaProgressView.this.progress);
                if (lastProgress < EtiyaProgressView.this.progress) {
                    Log.e("first", lastProgress + " to " + (incr * (EtiyaProgressView.this.progress)) + ":" + lastProgress);
                    animator = ValueAnimator.ofFloat(incr * lastProgress, incr * (EtiyaProgressView.this.progress));
                    animator.setDuration(800);
                    animator.addUpdateListener(animatorUpdateListener);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.start();
                } else {
                    Log.e("second", lastProgress + " to " + (incr * (EtiyaProgressView.this.progress)) + ":" + lastProgress);
                    animator = ValueAnimator.ofFloat((incr * lastProgress), incr * (EtiyaProgressView.this.progress));
                    animator.setDuration(800);
                    animator.addUpdateListener(animatorUpdateListener);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.start();
                }
            }
        });

    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float update = (float) (animation.getAnimatedValue());
            float incr = 360 / maxProgress;
            float value = (update / incr);
            progressUpdate = update;
            progressText = ((int) value) + "";
            invalidate();
        }
    };

    public void setTextColor(int textColors) {
        textPaint.setColor(textColors);
    }

    public void setPercentageColor(int textColors) {
        percentagePaint.setColor(textColors);
    }

    public void setPercentageText (String percentageText){
        PERCENTAGE_TEXT=percentageText;
    }

    public void setStartAngle(int startAngle){
        START_ANGLE=startAngle;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    public void setProgressColor(Integer progressColor) {
        progressPaint.setColor(progressColor);
    }

    public void setInnerCircleColor(int innerCircleColor) {
        innerCirclePaint.setStyle(Paint.Style.STROKE);
        innerCirclePaint.setColor(innerCircleColor);
    }

    public void setOuterCircleColor(int outerCircleColor) {
        outerCirclePaint.setStyle(Paint.Style.STROKE);
        outerCirclePaint.setColor(outerCircleColor);
    }

    public void setInnerCircleMargin(int innerCircleMargin) {
        this.innerCircleMargin = innerCircleMargin;
    }

    public float getMaxProgress() {
        return maxProgress;
    }

    public float getProgress() {
        return progress;
    }


}