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
        int Width = 200;
        int HeightTriangle = 100;
        int centerX = this.getWidth()/2;
        int centerY = this.getHeight()/2;

        Paint mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#89FF03"));
        mPaint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.moveTo(centerX , centerY-HeightTriangle); //위쪽 모서리
        path.lineTo(centerX + Width, centerY + HeightTriangle);//오른쪽 모서리
        path.lineTo(centerX - Width, centerY + HeightTriangle); //왼쪽 모서리
        path.lineTo(centerX , centerY-HeightTriangle);//MoveTo랑 경로가 같아야됨

        path.close();

        canvas.drawPath(path,mPaint);
    }
}
