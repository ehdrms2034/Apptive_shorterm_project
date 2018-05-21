package com.example.kimdonggeun.rgb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class graph_canvasview extends View {


    public graph_canvasview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int Width = 400;
        int HeightTriangle = 400;
        int centerX = this.getWidth()/2;
        int centerY = this.getHeight()/2;

        Paint mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.moveTo(centerX + Width / 2, centerY);
        path.lineTo(centerX + Width, centerY + HeightTriangle);
        path.lineTo(centerX, centerY + HeightTriangle);
        path.lineTo(centerX + Width / 2, centerY);

        path.close();

        canvas.drawPath(path,mPaint);
    }
}
