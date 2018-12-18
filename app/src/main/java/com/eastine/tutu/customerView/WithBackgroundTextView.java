package com.eastine.tutu.customerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.eastine.tutu.UIUtils;
import com.eastine.tutu.customview.R;


/**
 * @author ：wuchao on 2018/12/18 13：39
 */

public class WithBackgroundTextView extends TextView {

    private static final int DEFAULT_RADIUS = 0;
    private static final int DEFAULT_STROKE_WIDTH = 0;
    private static final int DEFAULT_BACKGROUND_COLOR = android.R.color.transparent;

    private Context context;

    /**
     * 背景色
     */
    private int withBackgroundColor;

    /**
     * 边框宽度 dp
     */
    private int withStrokeWidth;

    /**
     * 边框颜色
     */
    private int withStrokeColor;

    /**
     * 左上圆角度 dp
     */
    private int withTopLeftRadius;

    /**
     * 右上圆角度 dp
     */
    private int withTopRightRadius;

    /**
     * 左下圆角度 dp
     */
    private int withBottomLeftRadius;

    /**
     * 右下圆角度 dp
     */
    private int withBottomRightRadius;

    /**
     * 左圆角度 dp  左边两个角
     */
    private int withLeftRadius;

    /**
     * 右圆角度 dp  右边两个角
     */
    private int withRightRadius;

    /**
     * 圆角度 dp  四个角
     */
    private int withRadius;


    public WithBackgroundTextView(Context context) {
        this(context, null);
    }

    public WithBackgroundTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public WithBackgroundTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.WithBackgroundTextView, defStyleAttr, 0);

        withRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_radius, DEFAULT_RADIUS);
        withStrokeWidth = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withStrokeWidth, DEFAULT_STROKE_WIDTH);
        withStrokeColor = a.getColor(R.styleable.WithBackgroundTextView_withStrokeColor,
                ContextCompat.getColor(context, DEFAULT_BACKGROUND_COLOR));

        withTopLeftRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withTopLeftRadius, DEFAULT_RADIUS);
        withTopRightRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withTopRightRadius, DEFAULT_RADIUS);
        withBottomLeftRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withBottomLeftRadius, DEFAULT_RADIUS);
        withBottomRightRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withBottomRightRadius, DEFAULT_RADIUS);
        withLeftRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withLeftRadius, DEFAULT_RADIUS);
        if (withLeftRadius != DEFAULT_RADIUS) {
            withTopLeftRadius = withLeftRadius;
            withBottomLeftRadius = withLeftRadius;
        }
        withRightRadius = a.getDimensionPixelSize(R.styleable.WithBackgroundTextView_withRightRadius, DEFAULT_RADIUS);
        if (withRightRadius != DEFAULT_RADIUS) {
            withTopRightRadius = withRightRadius;
            withBottomRightRadius = withRightRadius;
        }

        withBackgroundColor = a.getColor(R.styleable.WithBackgroundTextView_withBackgroundColor,
                ContextCompat.getColor(context, DEFAULT_BACKGROUND_COLOR));
        a.recycle();

    }

    public void setWithBackgroundColor(int withBackgroundColor) {
        this.withBackgroundColor = withBackgroundColor;
    }

    public void setWithRadius(int radius) {
        this.withRadius = radius;
    }

    public void setWithTopLeftRadius(int withTopLeftRadius) {
        this.withTopLeftRadius = withTopLeftRadius;
    }

    public void setWithTopRightRadius(int withTopRightRadius) {
        this.withTopRightRadius = withTopRightRadius;
    }

    public void setWithBottomLeftRadius(int withBottomLeftRadius) {
        this.withBottomLeftRadius = withBottomLeftRadius;
    }

    public void setWithBottomRightRadius(int withBottomRightRadius) {
        this.withBottomRightRadius = withBottomRightRadius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground();
    }

    private void drawBackground() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        float[] radius = {UIUtils.dp2px(context, withTopLeftRadius), UIUtils.dp2px(context, withTopLeftRadius),
                UIUtils.dp2px(context, withTopRightRadius), UIUtils.dp2px(context, withTopRightRadius),
                UIUtils.dp2px(context, withBottomRightRadius), UIUtils.dp2px(context, withBottomRightRadius),
                UIUtils.dp2px(context, withBottomLeftRadius), UIUtils.dp2px(context, withBottomLeftRadius)};
        drawable.setCornerRadii(radius);
        if (withRadius != DEFAULT_RADIUS) {
            drawable.setCornerRadius(UIUtils.dp2px(context, withRadius));
        }
        drawable.setColor(withBackgroundColor);
        drawable.setStroke(UIUtils.dp2px(context, withStrokeWidth), withStrokeColor);
        this.setBackground(drawable);
    }

}
