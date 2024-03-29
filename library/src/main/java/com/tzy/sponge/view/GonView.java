package com.tzy.sponge.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.tzy.sponge.core.IGonView;
import com.tzy.sponge.delegate.GonViewDelegate;

/**
 * Created by tzy on 2017/8/1
 */
public class GonView extends View implements IGonView {
    private GonViewDelegate delegate;

    public GonView(Context context) {
        this(context, null);
    }

    public GonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        delegate.initAttributes(context, attrs);
    }

    @TargetApi(21)
    public GonView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        delegate.initAttributes(context, attrs);
    }

    private void init() {
        delegate = new GonViewDelegate(this);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        delegate.setLayoutParams();
    }

    @Override
    public void setGonSize(int width, int height) {
        delegate.setGonSize(width, height);
    }

    @Override
    public void setGonPadding(int padding) {
        delegate.setGonPadding(padding);
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        delegate.setGonPadding(left, top, right, bottom);
    }

    @Override
    public void setGonMargin(int margin) {
        delegate.setGonMargin(margin);
    }

    @Override
    public int getGonPaddingTop() {
        return delegate.getGonPaddingTop();
    }

    @Override
    public void setGonPaddingTop(int paddingTop) {
        delegate.setGonPaddingTop(paddingTop);
    }

    @Override
    public int getGonMarginBottom() {
        return delegate.getGonMarginBottom();
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        delegate.setGonMarginBottom(marginBottom);
    }

    @Override
    public int getGonWidth() {
        return delegate.getGonWidth();
    }

    @Override
    public void setGonWidth(int width) {
        delegate.setGonWidth(width);
    }

    @Override
    public int getGonHeight() {
        return delegate.getGonHeight();
    }

    @Override
    public void setGonHeight(int height) {
        delegate.setGonHeight(height);
    }

    @Override
    public int getGonPaddingLeft() {
        return delegate.getGonPaddingLeft();
    }

    @Override
    public void setGonPaddingLeft(int paddingLeft) {
        delegate.setGonPaddingLeft(paddingLeft);
    }

    @Override
    public int getGonPaddingRight() {
        return delegate.getGonPaddingRight();
    }

    @Override
    public void setGonPaddingRight(int paddingRight) {
        delegate.setGonPaddingRight(paddingRight);
    }

    @Override
    public int getGonPaddingBottom() {
        return delegate.getGonPaddingBottom();
    }

    @Override
    public void setGonPaddingBottom(int paddingBottom) {
        delegate.setGonPaddingBottom(paddingBottom);
    }

    @Override
    public int getGonMarginLeft() {
        return delegate.getGonMarginLeft();
    }

    @Override
    public void setGonMarginLeft(int marginLeft) {
        delegate.setGonMarginLeft(marginLeft);
    }

    @Override
    public int getGonMarginTop() {
        return delegate.getGonMarginTop();
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        delegate.setGonMarginTop(marginTop);
    }

    @Override
    public int getGonMarginRight() {
        return delegate.getGonMarginRight();
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        delegate.setGonMarginRight(marginRight);
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        delegate.setGonMargin(left, top, right, bottom);
    }
}
