package com.example.banglatextphotoeditor;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class RoundFrameLayout extends FrameLayout {
    private final RoundViewDelegate delegate;

    public RoundFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.delegate = new RoundViewDelegate(this, context, attributeSet);
    }

    public RoundViewDelegate getDelegate() {
        return this.delegate;
    }

    public void onMeasure(int i, int i2) {
        if (!this.delegate.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), MeasureSpec.EXACTLY);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.delegate.isRadiusHalfHeight()) {
            this.delegate.setCornerRadius(getHeight() / 2);
        } else {
            this.delegate.setBgSelector();
        }
    }
}
