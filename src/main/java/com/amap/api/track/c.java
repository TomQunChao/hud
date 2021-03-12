package com.amap.api.track;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICusAttriProvider */
public interface c extends IInterface {
    String a() throws RemoteException;

    /* compiled from: ICusAttriProvider */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.amap.api.track.ICusAttriProvider");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.track.ICusAttriProvider");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0005a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.amap.api.track.ICusAttriProvider");
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.amap.api.track.ICusAttriProvider");
                return true;
            }
        }

        /* renamed from: com.amap.api.track.c$a$a  reason: collision with other inner class name */
        /* compiled from: ICusAttriProvider */
        private static class C0005a implements c {
            private IBinder a;

            C0005a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.amap.api.track.c
            public final String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ICusAttriProvider");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
