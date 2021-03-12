package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Transformations {
    private Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> source, @NonNull final Function<X, Y> func) {
        final MediatorLiveData<Y> result = new MediatorLiveData<>();
        result.addSource(source, new Observer<X>() {
            /* class android.arch.lifecycle.Transformations.AnonymousClass1 */

            @Override // android.arch.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                result.setValue(func.apply(x));
            }
        });
        return result;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> trigger, @NonNull final Function<X, LiveData<Y>> func) {
        final MediatorLiveData<Y> result = new MediatorLiveData<>();
        result.addSource(trigger, new Observer<X>() {
            /* class android.arch.lifecycle.Transformations.AnonymousClass2 */
            LiveData<Y> mSource;

            @Override // android.arch.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                LiveData<Y> newLiveData = (LiveData) func.apply(x);
                LiveData<Y> liveData = this.mSource;
                if (liveData != newLiveData) {
                    if (liveData != null) {
                        result.removeSource(liveData);
                    }
                    this.mSource = newLiveData;
                    LiveData<Y> liveData2 = this.mSource;
                    if (liveData2 != null) {
                        result.addSource(liveData2, new Observer<Y>() {
                            /* class android.arch.lifecycle.Transformations.AnonymousClass2.AnonymousClass1 */

                            @Override // android.arch.lifecycle.Observer
                            public void onChanged(@Nullable Y y) {
                                result.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return result;
    }
}
