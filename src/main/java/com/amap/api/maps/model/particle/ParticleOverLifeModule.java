package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public class ParticleOverLifeModule extends AbstractNativeInstance implements Parcelable {
    public static final Parcelable.Creator<ParticleOverLifeModule> CREATOR = new Parcelable.Creator<ParticleOverLifeModule>() {
        /* class com.amap.api.maps.model.particle.ParticleOverLifeModule.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParticleOverLifeModule createFromParcel(Parcel parcel) {
            return new ParticleOverLifeModule(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParticleOverLifeModule[] newArray(int i) {
            return new ParticleOverLifeModule[i];
        }
    };
    private VelocityGenerate a = null;
    private RotationOverLife b;
    private SizeOverLife c;
    private ColorGenerate d;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    protected ParticleOverLifeModule(Parcel parcel) {
        this.nativeInstance = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.nativeInstance);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance, java.lang.Object
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleOverLifeModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public ParticleOverLifeModule() {
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleOverLifeModule();
            if (this.e) {
                setVelocityOverLife(this.a);
                this.e = false;
            }
            if (this.f) {
                setRotateOverLife(this.b);
                this.f = false;
            }
            if (this.g) {
                setSizeOverLife(this.c);
                this.g = false;
            }
            if (this.h) {
                setColorGenerate(this.d);
                this.h = false;
            }
        } catch (Throwable th) {
        }
    }

    public void setVelocityOverLife(VelocityGenerate velocityGenerate) {
        this.a = velocityGenerate;
        if (this.nativeInstance != 0) {
            VelocityGenerate velocityGenerate2 = this.a;
            if (velocityGenerate2 != null) {
                if (velocityGenerate2.getNativeInstance() == 0) {
                    this.a.createNativeInstace();
                }
                AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.a.getNativeInstance(), 0);
                return;
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 0);
            return;
        }
        this.e = true;
    }

    public void setRotateOverLife(RotationOverLife rotationOverLife) {
        this.b = rotationOverLife;
        if (this.nativeInstance != 0) {
            RotationOverLife rotationOverLife2 = this.b;
            if (rotationOverLife2 != null) {
                if (rotationOverLife2.getNativeInstance() == 0) {
                    this.b.createNativeInstace();
                }
                AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.b.getNativeInstance(), 1);
                return;
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 1);
            return;
        }
        this.f = true;
    }

    public void setSizeOverLife(SizeOverLife sizeOverLife) {
        this.c = sizeOverLife;
        if (this.nativeInstance != 0) {
            SizeOverLife sizeOverLife2 = this.c;
            if (sizeOverLife2 != null) {
                if (sizeOverLife2.getNativeInstance() == 0) {
                    this.c.createNativeInstace();
                }
                AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.c.getNativeInstance(), 2);
                return;
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 2);
            return;
        }
        this.g = true;
    }

    public void setColorGenerate(ColorGenerate colorGenerate) {
        this.d = colorGenerate;
        if (this.nativeInstance != 0) {
            ColorGenerate colorGenerate2 = this.d;
            if (colorGenerate2 != null) {
                if (colorGenerate2.getNativeInstance() == 0) {
                    this.d.createNativeInstace();
                }
                AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.d.getNativeInstance(), 3);
                return;
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 3);
            return;
        }
        this.h = true;
    }
}
