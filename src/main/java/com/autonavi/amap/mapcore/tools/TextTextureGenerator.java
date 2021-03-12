package com.autonavi.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.nio.ByteBuffer;

public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    public static final int CHAR_MAX = 256;
    public static final int MIN_DIFF_SIZE = 4;
    private float baseLine = 0.0f;
    private float startX = 0.0f;
    private int textFontsize = -1;
    private int textFontsizeTrue = -1;
    private Paint textPaint = null;

    public static int getNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    public TextTextureGenerator() {
        createTextParam();
    }

    private void createTextParam() {
        float f;
        this.textFontsizeTrue = this.textFontsize - 2;
        this.textPaint = newPaint(null, this.textFontsizeTrue, 49);
        float f2 = ((float) (this.textFontsize - this.textFontsizeTrue)) / 2.0f;
        this.startX = f2;
        float f3 = 7.3242188f;
        try {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            f3 = fontMetrics.descent;
            f = fontMetrics.ascent;
        } catch (Exception e) {
            f = -27.832031f;
        }
        this.baseLine = ((((float) this.textFontsizeTrue) - (f3 + f)) / 2.0f) + f2 + 0.5f;
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        float f;
        if (this.textFontsize != i2) {
            this.textFontsize = i2;
            createTextParam();
        }
        try {
            char c = (char) i;
            char[] cArr = {c};
            float f2 = this.baseLine;
            Bitmap createBitmap = Bitmap.createBitmap(this.textFontsize, this.textFontsize, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            byte[] bArr = new byte[(this.textFontsize * this.textFontsize)];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.textPaint.measureText(String.valueOf(c));
            if (cArr[0] <= 0 || cArr[0] >= 256) {
                f = f2;
            } else {
                f = f2 - 1.5f;
            }
            Paint.Align textAlign = this.textPaint.getTextAlign();
            float f3 = measureText - ((float) this.textFontsizeTrue);
            if (textAlign == Paint.Align.CENTER || f3 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.startX, f, this.textPaint);
            } else {
                this.textPaint.setTextAlign(Paint.Align.CENTER);
                this.textPaint.setTextSize(((float) this.textFontsizeTrue) - f3);
                canvas.drawText(cArr, 0, 1, (((float) this.textFontsizeTrue) - f3) / 2.0f, f, this.textPaint);
                this.textPaint.setTextAlign(textAlign);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            createBitmap.recycle();
            return bArr;
        } catch (Exception | OutOfMemoryError e) {
            return null;
        }
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i = 0; i < length; i++) {
            Paint paint = this.textPaint;
            StringBuilder sb = new StringBuilder();
            sb.append((char) iArr[i]);
            fArr[0] = paint.measureText(sb.toString());
            bArr[i] = (byte) ((int) (fArr[0] + ((float) (this.textFontsize - this.textFontsizeTrue))));
        }
        return bArr;
    }

    private static Paint newPaint(String str, int i, int i2) {
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(-1);
        textPaint2.setTextSize((float) i);
        textPaint2.setAntiAlias(true);
        textPaint2.setFilterBitmap(true);
        textPaint2.setTypeface(Typeface.DEFAULT);
        switch (i2) {
            case 49:
                textPaint2.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint2.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                textPaint2.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint2.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint2;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }
}
