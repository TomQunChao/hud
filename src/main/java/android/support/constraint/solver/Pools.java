package android.support.constraint.solver;

final class Pools {
    private static final boolean DEBUG = false;

    /* access modifiers changed from: package-private */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i);
    }

    private Pools() {
    }

    /* access modifiers changed from: package-private */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int maxPoolSize) {
            if (maxPoolSize > 0) {
                this.mPool = new Object[maxPoolSize];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i <= 0) {
                return null;
            }
            int lastPooledIndex = i - 1;
            Object[] objArr = this.mPool;
            T instance = (T) objArr[lastPooledIndex];
            objArr[lastPooledIndex] = null;
            this.mPoolSize = i - 1;
            return instance;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public boolean release(T instance) {
            int i = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = instance;
            this.mPoolSize = i + 1;
            return true;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public void releaseAll(T[] variables, int count) {
            if (count > variables.length) {
                count = variables.length;
            }
            for (int i = 0; i < count; i++) {
                T instance = variables[i];
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 < objArr.length) {
                    objArr[i2] = instance;
                    this.mPoolSize = i2 + 1;
                }
            }
        }

        private boolean isInPool(T instance) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == instance) {
                    return true;
                }
            }
            return false;
        }
    }
}
