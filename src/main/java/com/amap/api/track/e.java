package com.amap.api.track;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amap.api.track.c;
import com.amap.api.track.d;

/* compiled from: ITrackService */
public interface e extends IInterface {
    long a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(TrackParam trackParam, d dVar) throws RemoteException;

    void a(TrackParam trackParam, f fVar, c cVar, d dVar) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void a(d dVar) throws RemoteException;

    void a(String str) throws RemoteException;

    String b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(d dVar) throws RemoteException;

    void c(int i) throws RemoteException;

    void c(d dVar) throws RemoteException;

    /* compiled from: ITrackService */
    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.amap.api.track.ITrackService");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.track.ITrackService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0007a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            TrackParam trackParam;
            if (i != 1598968902) {
                f fVar = null;
                TrackParam trackParam2 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        b(d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        if (parcel.readInt() != 0) {
                            trackParam = TrackParam.CREATOR.createFromParcel(parcel);
                        } else {
                            trackParam = null;
                        }
                        if (parcel.readInt() != 0) {
                            fVar = f.g.createFromParcel(parcel);
                        }
                        a(trackParam, fVar, c.a.a(parcel.readStrongBinder()), d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        if (parcel.readInt() != 0) {
                            trackParam2 = TrackParam.CREATOR.createFromParcel(parcel);
                        }
                        a(trackParam2, d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        long a = a();
                        parcel2.writeNoException();
                        parcel2.writeLong(a);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        String b = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        b(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        c(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        a(c.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.amap.api.track.ITrackService");
                        c(d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.amap.api.track.ITrackService");
                return true;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: com.amap.api.track.e$a$a  reason: collision with other inner class name */
        /* compiled from: ITrackService */
        public static class C0007a implements e {
            private IBinder a;

            C0007a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.amap.api.track.e
            public final void a(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void b(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(TrackParam trackParam, f fVar, c cVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    if (trackParam != null) {
                        obtain.writeInt(1);
                        trackParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fVar != null) {
                        obtain.writeInt(1);
                        fVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(TrackParam trackParam, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    if (trackParam != null) {
                        obtain.writeInt(1);
                        trackParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeLong(j);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final long a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeString(str);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeInt(i);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeInt(i);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeInt(i);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amap.api.track.e
            public final void c(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.track.ITrackService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
