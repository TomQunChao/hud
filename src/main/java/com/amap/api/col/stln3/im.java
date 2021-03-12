package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndoorFloorSwitchView */
public class im extends ScrollView {
    public static final String a = im.class.getSimpleName();
    int b = 1;
    private Context c;
    private LinearLayout d;
    private int e = 0;
    private List<String> f;
    private int g = -1;
    private int h;
    private Bitmap i = null;
    private int j = Color.parseColor("#eeffffff");
    private int k = Color.parseColor("#44383838");
    private int l = 4;
    private int m = 1;
    private int n;
    private int o;
    private Runnable p;
    private int q = 50;
    private a r;

    /* compiled from: IndoorFloorSwitchView */
    public interface a {
        void a(int i);
    }

    static /* synthetic */ void d(im imVar) {
        a aVar = imVar.r;
        if (aVar != null) {
            try {
                int i2 = 0;
                if (imVar.f != null) {
                    if (imVar.f.size() != 0) {
                        i2 = Math.min(imVar.f.size() - (imVar.m * 2), Math.max(0, ((imVar.f.size() - 1) - imVar.b) - imVar.m));
                    }
                }
                aVar.a(i2);
            } catch (Throwable th) {
            }
        }
    }

    static /* synthetic */ int[] i(im imVar) {
        int i2 = imVar.e;
        int i3 = imVar.m;
        return new int[]{i2 * i3, i2 * (i3 + 1)};
    }

    public im(Context context) {
        super(context);
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                InputStream open = hw.a(context).open("map_indoor_select.png");
                this.i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable th) {
        }
        this.d = new LinearLayout(context);
        this.d.setOrientation(1);
        addView(this.d);
        this.p = new Runnable() {
            /* class com.amap.api.col.stln3.im.AnonymousClass1 */

            public final void run() {
                if (im.this.o - im.this.getScrollY() != 0) {
                    im imVar = im.this;
                    imVar.o = imVar.getScrollY();
                    im imVar2 = im.this;
                    imVar2.postDelayed(imVar2.p, (long) im.this.q);
                } else if (im.this.e != 0) {
                    final int i = im.this.o % im.this.e;
                    final int i2 = im.this.o / im.this.e;
                    if (i == 0) {
                        im imVar3 = im.this;
                        imVar3.b = i2 + imVar3.m;
                        im.d(im.this);
                    } else if (i > im.this.e / 2) {
                        im.this.post(new Runnable() {
                            /* class com.amap.api.col.stln3.im.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                im.this.smoothScrollTo(0, (im.this.o - i) + im.this.e);
                                im.this.b = i2 + im.this.m + 1;
                                im.d(im.this);
                            }
                        });
                    } else {
                        im.this.post(new Runnable() {
                            /* class com.amap.api.col.stln3.im.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                im.this.smoothScrollTo(0, im.this.o - i);
                                im.this.b = i2 + im.this.m;
                                im.d(im.this);
                            }
                        });
                    }
                }
            }
        };
    }

    private void c() {
        List<String> list = this.f;
        if (!(list == null || list.size() == 0)) {
            this.d.removeAllViews();
            this.n = (this.m * 2) + 1;
            for (int size = this.f.size() - 1; size >= 0; size--) {
                LinearLayout linearLayout = this.d;
                TextView textView = new TextView(this.c);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                textView.setSingleLine(true);
                textView.setTextSize(2, 16.0f);
                textView.setText(this.f.get(size));
                textView.setGravity(17);
                textView.getPaint().setFakeBoldText(true);
                int a2 = a(this.c, 8.0f);
                int a3 = a(this.c, 6.0f);
                textView.setPadding(a2, a3, a2, a3);
                if (this.e == 0) {
                    textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
                    this.e = textView.getMeasuredHeight();
                    this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
                    setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
                }
                linearLayout.addView(textView);
            }
            a(0);
        }
    }

    private void a(int i2) {
        int i3 = this.e;
        if (i3 != 0) {
            int i4 = this.m;
            int i5 = (i2 / i3) + i4;
            int i6 = i2 % i3;
            int i7 = i2 / i3;
            if (i6 == 0) {
                i5 = i7 + i4;
            } else if (i6 > i3 / 2) {
                i5 = i7 + i4 + 1;
            }
            int childCount = this.d.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                TextView textView = (TextView) this.d.getChildAt(i8);
                if (textView != null) {
                    if (i5 == i8) {
                        textView.setTextColor(Color.parseColor("#0288ce"));
                    } else {
                        textView.setTextColor(Color.parseColor("#bbbbbb"));
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void a(String[] strArr) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        for (String str : strArr) {
            this.f.add(str);
        }
        for (int i2 = 0; i2 < this.m; i2++) {
            this.f.add(0, "");
            this.f.add("");
        }
        c();
    }

    public void setBackgroundColor(int i2) {
        this.j = i2;
    }

    public final void a() {
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.c.getSystemService("window");
                if (windowManager != null) {
                    this.h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() {
            /* class com.amap.api.col.stln3.im.AnonymousClass2 */

            public final void draw(Canvas canvas) {
                try {
                    canvas.drawColor(im.this.j);
                    Paint paint = new Paint();
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    rect.left = 0;
                    rect.top = 0;
                    rect.right = im.this.i.getWidth() + 0;
                    rect.bottom = im.this.i.getHeight() + 0;
                    rect2.left = 0;
                    rect2.top = im.i(im.this)[0];
                    rect2.right = im.this.h + 0;
                    rect2.bottom = im.i(im.this)[1];
                    canvas.drawBitmap(im.this.i, rect, rect2, paint);
                    Paint paint2 = new Paint();
                    Rect clipBounds = canvas.getClipBounds();
                    paint2.setColor(im.this.k);
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setStrokeWidth((float) im.this.l);
                    canvas.drawRect(clipBounds, paint2);
                } catch (Throwable th) {
                }
            }

            public final void setAlpha(int i) {
            }

            public final void setColorFilter(ColorFilter colorFilter) {
            }

            public final int getOpacity() {
                return 0;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.h = i2;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a(i3);
        if (i3 > i5) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    public final void a(String str) {
        List<String> list = this.f;
        if (list != null && list.size() != 0) {
            int indexOf = this.f.indexOf(str);
            int size = this.f.size();
            int i2 = this.m;
            final int i3 = ((size - i2) - 1) - indexOf;
            this.b = i2 + i3;
            post(new Runnable() {
                /* class com.amap.api.col.stln3.im.AnonymousClass3 */

                public final void run() {
                    im imVar = im.this;
                    imVar.smoothScrollTo(0, i3 * imVar.e);
                }
            });
        }
    }

    public void fling(int i2) {
        super.fling(i2 / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.o = getScrollY();
            postDelayed(this.p, (long) this.q);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void a(a aVar) {
        this.r = aVar;
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public final boolean b() {
        return getVisibility() == 0;
    }
}
