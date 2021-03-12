package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BitmapDescriptor;

public class ParticleOverlayOptions implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ParticleOverlayOptions> CREATOR = new Parcelable.Creator<ParticleOverlayOptions>() {
        /* class com.amap.api.maps.model.particle.ParticleOverlayOptions.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParticleOverlayOptions createFromParcel(Parcel parcel) {
            return new ParticleOverlayOptions(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParticleOverlayOptions[] newArray(int i) {
            return new ParticleOverlayOptions[i];
        }
    };
    private BitmapDescriptor a;
    private float b;
    private int c;
    private boolean d;
    private long e;
    private long f;
    private ParticleEmissionModule g;
    private ParticleShapeModule h;
    private VelocityGenerate i;
    private ColorGenerate j;
    private ParticleOverLifeModule k;
    private int l;
    private int m;
    private boolean n;

    public ParticleOverlayOptions() {
        this.b = 1.0f;
        this.c = 100;
        this.d = true;
        this.e = 5000;
        this.f = 5000;
        this.i = null;
        this.l = 32;
        this.m = 32;
        this.n = true;
    }

    protected ParticleOverlayOptions(Parcel parcel) {
        this.b = 1.0f;
        this.c = 100;
        boolean z = true;
        this.d = true;
        this.e = 5000;
        this.f = 5000;
        this.i = null;
        this.l = 32;
        this.m = 32;
        this.n = true;
        this.a = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.b = parcel.readFloat();
        this.c = parcel.readInt();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readByte() == 0 ? false : z;
    }

    public ParticleOverlayOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            this.a = bitmapDescriptor;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public BitmapDescriptor getIcon() {
        return this.a;
    }

    public int getMaxParticles() {
        return this.c;
    }

    public ParticleOverlayOptions setMaxParticles(int i2) {
        this.c = i2;
        return this;
    }

    public boolean isLoop() {
        return this.d;
    }

    public ParticleOverlayOptions setLoop(boolean z) {
        this.d = z;
        return this;
    }

    public long getDuration() {
        return this.e;
    }

    public ParticleOverlayOptions setDuration(long j2) {
        this.e = j2;
        return this;
    }

    public long getParticleLifeTime() {
        return this.f;
    }

    public ParticleOverlayOptions setParticleLifeTime(long j2) {
        this.f = j2;
        return this;
    }

    public ParticleEmissionModule getParticleEmissionModule() {
        return this.g;
    }

    public ParticleOverlayOptions setParticleEmissionModule(ParticleEmissionModule particleEmissionModule) {
        this.g = particleEmissionModule;
        return this;
    }

    public ParticleShapeModule getParticleShapeModule() {
        return this.h;
    }

    public ParticleOverlayOptions setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        this.h = particleShapeModule;
        return this;
    }

    public VelocityGenerate getParticleStartSpeed() {
        return this.i;
    }

    public ParticleOverlayOptions setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        this.i = velocityGenerate;
        return this;
    }

    public ParticleOverlayOptions setParticleStartColor(ColorGenerate colorGenerate) {
        this.j = colorGenerate;
        return this;
    }

    public ColorGenerate getParticleStartColor() {
        return this.j;
    }

    public ParticleOverlayOptions setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        this.k = particleOverLifeModule;
        return this;
    }

    public ParticleOverLifeModule getParticleOverLifeModule() {
        return this.k;
    }

    public ParticleOverlayOptions setStartParticleSize(int i2, int i3) {
        this.l = i2;
        this.m = i3;
        return this;
    }

    public int getStartParticleW() {
        return this.l;
    }

    public int getstartParticleH() {
        return this.m;
    }

    public ParticleOverlayOptions zIndex(float f2) {
        this.b = f2;
        return this;
    }

    public float getZIndex() {
        return this.b;
    }

    public ParticleOverlayOptions setVisible(boolean z) {
        this.n = z;
        return this;
    }

    public boolean isVisibile() {
        return this.n;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeFloat(this.b);
        parcel.writeInt(this.c);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeByte(this.n ? (byte) 1 : 0);
    }
}
