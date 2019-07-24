package com.tzy.sponge.delegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.tzy.sponge.GonScreenAdapter;
import com.tzy.sponge.core.IGonView;
import com.dangbei.gonzalez.R;

/**
 * Created by tzy on 2017/8/1
 */
public class GonViewDelegate implements IGonView {
    static final int GON_NO_VALUE = Integer.MIN_VALUE;
    protected View view;

    private int gonWidth = GON_NO_VALUE;
    private int gonHeight = GON_NO_VALUE;

    private int gonPaddingLeft = GON_NO_VALUE;
    private int gonPaddingTop = GON_NO_VALUE;
    private int gonPaddingRight = GON_NO_VALUE;
    private int gonPaddingBottom = GON_NO_VALUE;

    private int gonMarginLeft = GON_NO_VALUE;
    private int gonMarginTop = GON_NO_VALUE;
    private int gonMarginRight = GON_NO_VALUE;
    private int gonMarginBottom = GON_NO_VALUE;

    public GonViewDelegate(View view) {
        this.view = view;
    }

    public void initAttributes(Context context, AttributeSet attrs) {
        GonScreenAdapter.getInstance().init(context.getResources().getDisplayMetrics());

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonWidth = typedArray.getInt(R.styleable.GonView_gon_layout_width, GON_NO_VALUE);
        gonHeight = typedArray.getInt(R.styleable.GonView_gon_layout_height, GON_NO_VALUE);

        int padding = typedArray.getInt(R.styleable.GonView_gon_padding, GON_NO_VALUE);

        gonPaddingLeft = typedArray.getInt(R.styleable.GonView_gon_paddingLeft, padding);
        gonPaddingTop = typedArray.getInt(R.styleable.GonView_gon_paddingTop, padding);
        gonPaddingRight = typedArray.getInt(R.styleable.GonView_gon_paddingRight, padding);
        gonPaddingBottom = typedArray.getInt(R.styleable.GonView_gon_paddingBottom, padding);

        int margin = typedArray.getInt(R.styleable.GonView_gon_layout_margin, GON_NO_VALUE);

        gonMarginLeft = typedArray.getInt(R.styleable.GonView_gon_layout_marginLeft, margin);
        gonMarginTop = typedArray.getInt(R.styleable.GonView_gon_layout_marginTop, margin);
        gonMarginRight = typedArray.getInt(R.styleable.GonView_gon_layout_marginRight, margin);
        gonMarginBottom = typedArray.getInt(R.styleable.GonView_gon_layout_marginBottom, margin);

        typedArray.recycle();
    }

    public void setLayoutParams() {
        setGonSize(gonWidth, gonHeight);
        setGonMargin(gonMarginLeft, gonMarginTop, gonMarginRight, gonMarginBottom);
        setGonPadding(gonPaddingLeft, gonPaddingTop, gonPaddingRight, gonPaddingBottom);
    }


    @Override
    public void setGonSize(int width, int height) {
        setGonWidth(width);
        setGonHeight(height);
    }

    @Override
    public int getGonWidth() {
        return gonWidth;
    }

    @Override
    public void setGonWidth(int width) {
        if (width != GON_NO_VALUE) {
            this.gonWidth = width;
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params != null) {
                if (GonScreenAdapter.WRAP != width && GonScreenAdapter.MATCH != width) {
                    width = GonScreenAdapter.getInstance().scaleX(width);
                }
                params.width = width;
            }
        }
    }

    @Override
    public int getGonHeight() {
        return gonHeight;
    }

    @Override
    public void setGonHeight(int height) {
        if (height != GON_NO_VALUE) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            this.gonHeight = height;
            if (params != null) {
                if (GonScreenAdapter.WRAP != height && GonScreenAdapter.MATCH != height) {
                    height = GonScreenAdapter.getInstance().scaleY(height);
                }
                params.height = height;
            }
        }
    }

    @Override
    public void setGonPadding(int padding) {
        setGonPadding(padding, padding, padding, padding);
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        if (left == GON_NO_VALUE) {
            left = view.getPaddingLeft();
        } else {
            this.gonPaddingLeft = left;
        }
        if (top == GON_NO_VALUE) {
            top = view.getPaddingTop();
        } else {
            this.gonPaddingTop = top;
        }
        if (right == GON_NO_VALUE) {
            right = view.getPaddingRight();
        } else {
            this.gonPaddingRight = right;
        }
        if (bottom == GON_NO_VALUE) {
            bottom = view.getPaddingBottom();
        } else {
            this.gonPaddingBottom = bottom;
        }
        GonScreenAdapter adapter = GonScreenAdapter.getInstance();
        view.setPadding(adapter.scaleX(left), adapter.scaleY(top), adapter.scaleX(right), adapter.scaleY(bottom));
    }

    @Override
    public int getGonPaddingLeft() {
        return gonPaddingLeft;
    }

    @Override
    public void setGonPaddingLeft(int paddingLeft) {
        setGonPadding(paddingLeft, GON_NO_VALUE, GON_NO_VALUE, GON_NO_VALUE);
    }

    @Override
    public int getGonPaddingTop() {
        return gonPaddingTop;
    }

    @Override
    public void setGonPaddingTop(int paddingTop) {
        setGonPadding(GON_NO_VALUE, paddingTop, GON_NO_VALUE, GON_NO_VALUE);
    }

    @Override
    public int getGonPaddingRight() {
        return gonPaddingRight;
    }

    @Override
    public void setGonPaddingRight(int paddingRight) {
        setGonPadding(GON_NO_VALUE, GON_NO_VALUE, paddingRight, GON_NO_VALUE);
    }

    @Override
    public int getGonPaddingBottom() {
        return gonPaddingBottom;
    }

    @Override
    public void setGonPaddingBottom(int paddingBottom) {
        setGonPadding(GON_NO_VALUE, GON_NO_VALUE, GON_NO_VALUE, paddingBottom);
    }

    @Override
    public void setGonMargin(int margin) {
        setGonMargin(margin, margin, margin, margin);
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        setGonMarginLeft(left);
        setGonMarginTop(top);
        setGonMarginRight(right);
        setGonMarginBottom(bottom);
    }

    @Override
    public int getGonMarginLeft() {
        return gonMarginLeft;
    }

    @Override
    public void setGonMarginLeft(int marginLeft) {
        if (marginLeft != GON_NO_VALUE) {
            this.gonMarginLeft = marginLeft;
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) params).leftMargin = GonScreenAdapter.getInstance().scaleX(marginLeft);
            }
        }
    }

    @Override
    public int getGonMarginTop() {
        return gonMarginTop;
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        if (marginTop != GON_NO_VALUE) {
            this.gonMarginTop = marginTop;
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) params).topMargin = GonScreenAdapter.getInstance().scaleY(marginTop);
            }
        }
    }

    @Override
    public int getGonMarginRight() {
        return gonMarginRight;
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        if (marginRight != GON_NO_VALUE) {
            this.gonMarginRight = marginRight;
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) params).rightMargin = GonScreenAdapter.getInstance().scaleX(marginRight);
            }
        }
    }

    @Override
    public int getGonMarginBottom() {
        return gonMarginBottom;
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        if (marginBottom != GON_NO_VALUE) {
            this.gonMarginBottom = marginBottom;
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) params).bottomMargin = GonScreenAdapter.getInstance().scaleY(marginBottom);
            }
        }
    }
}
