package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * baseline平齐...
         * drawText 的 y轴坐标即使baseLine,只要传入统一的y轴坐标,那么baseLine就是统一的.
         *
         */
        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐
        float ascent = paint2.ascent();
        float descent = paint2.descent();
        int middle = (top + bottom) / 2;
        float middleText = (descent - ascent) / 2 - descent;
        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);
        canvas.drawText(texts[0], 100, middle + middleText, paint2);
        canvas.drawText(texts[1], 200, middle + middleText, paint2);
        canvas.drawText(texts[2], 300, middle + middleText, paint2);
        canvas.drawText(texts[3], 400, middle + middleText, paint2);
        canvas.drawText(texts[4], 500, middle + middleText, paint2);
        canvas.drawText(texts[5], 600, middle + middleText, paint2);

    }
}
