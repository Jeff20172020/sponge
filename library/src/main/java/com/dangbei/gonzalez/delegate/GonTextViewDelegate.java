package com.dangbei.gonzalez.delegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.dangbei.gonzalez.GonScreenAdapter;
import com.dangbei.gonzalez.core.IGonTextView;
import com.dangbei.gonzalez.R;

/**
 * Created by guoxiaodong on 2017/8/4
 */
public class GonTextViewDelegate extends GonViewDelegate implements IGonTextView {
    private int gonTextSize;
    private int drawableWidth;
    private int drawableHeight;
    private int drawablePadding;
    private Drawable drawableLeft;
    private Drawable drawableTop;
    private Drawable drawableRight;
    private Drawable drawableBottom;
    private int gonMaxWidth;
    private int gonMaxHeight;

    public GonTextViewDelegate(View view) {
        super(view);
    }

    @Override
    public void initAttributes(Context context, AttributeSet attrs) {
        super.initAttributes(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, GON_NO_VALUE);
        drawableWidth = typedArray.getInt(R.styleable.GonView_gon_drawableWidth, GON_NO_VALUE);
        drawableHeight = typedArray.getInt(R.styleable.GonView_gon_drawableHeight, GON_NO_VALUE);
        drawablePadding = typedArray.getInt(R.styleable.GonView_gon_drawablePadding, GON_NO_VALUE);

        drawableLeft = typedArray.getDrawable(R.styleable.GonView_android_drawableLeft);
        drawableTop = typedArray.getDrawable(R.styleable.GonView_android_drawableTop);
        drawableRight = typedArray.getDrawable(R.styleable.GonView_android_drawableRight);
        drawableBottom = typedArray.getDrawable(R.styleable.GonView_android_drawableBottom);

        gonMaxWidth = typedArray.getInt(R.styleable.GonView_gon_layout_max_width, GON_NO_VALUE);
        gonMaxHeight = typedArray.getInt(R.styleable.GonView_gon_layout_max_height, GON_NO_VALUE);

        typedArray.recycle();
    }

    @Override
    public void setLayoutParams() {
        super.setLayoutParams();

        if (view instanceof TextView) {
            setGonTextSize(gonTextSize);
            setGonMaxWidth(gonMaxWidth);
            setGonMaxHeight(gonMaxHeight);
            setGonDrawableLeft(drawableLeft, drawablePadding, drawableWidth, drawableHeight);
            setGonDrawableTop(drawableTop, drawablePadding, drawableWidth, drawableHeight);
            setGonDrawableRight(drawableRight, drawablePadding, drawableWidth, drawableHeight);
            setGonDrawableBottom(drawableBottom, drawablePadding, drawableWidth, drawableHeight);
        }
    }

    @Override
    public void setGonTextSize(int textSize) {
        if (textSize != GON_NO_VALUE && view instanceof TextView) {
            this.gonTextSize = textSize;
            GonScreenAdapter.getInstance().scaleTextSize(view, textSize);
        }
    }

    @Override
    public void setGonMaxWidth(int maxWidth) {
        if (maxWidth != GON_NO_VALUE && view instanceof TextView) {
            this.gonMaxWidth = maxWidth;
            ((TextView) view).setMaxWidth(GonScreenAdapter.getInstance().scaleX(maxWidth));
        }
    }

    @Override
    public void setGonMaxHeight(int maxHeight) {
        if (maxHeight != GON_NO_VALUE && view instanceof TextView) {
            this.gonMaxHeight = maxHeight;
            ((TextView) view).setMaxHeight(GonScreenAdapter.getInstance().scaleY(maxHeight));
        }
    }

    @Override
    public void setGonDrawableLeft(Drawable drawable, int padding, int width, int height) {
        setDrawableByOrientation(drawable, padding, width, height, 0);
    }

    @Override
    public void setGonDrawableTop(Drawable drawable, int padding, int width, int height) {
        setDrawableByOrientation(drawable, padding, width, height, 1);
    }

    @Override
    public void setGonDrawableRight(Drawable drawable, int padding, int width, int height) {
        setDrawableByOrientation(drawable, padding, width, height, 2);
    }

    @Override
    public void setGonDrawableBottom(Drawable drawable, int padding, int width, int height) {
        setDrawableByOrientation(drawable, padding, width, height, 3);
    }

    private void setDrawableByOrientation(Drawable drawable, int padding, int width, int height, int orientation) {
        if (drawable != null && padding != GON_NO_VALUE && width != GON_NO_VALUE && height != GON_NO_VALUE && view instanceof TextView) {
            this.drawableLeft = drawable;
            this.drawablePadding = padding;
            this.drawableWidth = width;
            this.drawableHeight = height;

            GonScreenAdapter adapter = GonScreenAdapter.getInstance();
            drawable.setBounds(0, 0, adapter.scaleX(width), adapter.scaleY(height));

            ((TextView) view).setCompoundDrawablePadding(orientation % 2 == 0 ? adapter.scaleX(padding) : adapter.scaleY(padding));
            switch (orientation) {
                case 0:
                    ((TextView) view).setCompoundDrawables(drawable, null, null, null);
                    break;
                case 1:
                    ((TextView) view).setCompoundDrawables(null, drawable, null, null);
                    break;
                case 2:
                    ((TextView) view).setCompoundDrawables(null, null, drawable, null);
                    break;
                case 3:
                    ((TextView) view).setCompoundDrawables(null, null, null, drawable);
                    break;
            }
        }
    }
}
