package android.support.constraint.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public void setBounds(int x2, int y2, int width2, int height2) {
        this.x = x2;
        this.y = y2;
        this.width = width2;
        this.height = height2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int w, int h) {
        this.x -= w;
        this.y -= h;
        this.width += w * 2;
        this.height += h * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle bounds) {
        int i;
        int i2;
        int i3 = this.x;
        int i4 = bounds.x;
        return i3 >= i4 && i3 < i4 + bounds.width && (i = this.y) >= (i2 = bounds.y) && i < i2 + bounds.height;
    }

    public boolean contains(int x2, int y2) {
        int i;
        int i2 = this.x;
        return x2 >= i2 && x2 < i2 + this.width && y2 >= (i = this.y) && y2 < i + this.height;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }
}
