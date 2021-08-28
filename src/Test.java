//import java.io.Serializable;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//
//public class ReentrantReadWriteLock implements ReadWriteLock, Serializable {
//
//    private final ReentrantReadWriteLock.ReadLock readerLock;
//
//    private final ReentrantReadWriteLock.WriteLock writerLock;
//
//    final ReentrantReadWriteLock.Sync sync;
//
//    public ReentrantReadWriteLock() { // 默认是非公平
//        this(false);
//    }
//
//    public ReentrantReadWriteLock(boolean fair) {
//        sync = fair ? new ReentrantReadWriteLock.FairSync() : new ReentrantReadWriteLock.NonfairSync();
//        readerLock = new ReentrantReadWriteLock.ReadLock(this);
//        writerLock = new ReentrantReadWriteLock.WriteLock(this);
//    }
//
//    abstract static class Sync extends AbstractQueuedSynchronizer {
//        static final int SHARED_SHIFT = 16;
//        static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1; // 低16位全是1，代表了读写锁的最大计数，即可重入的最大值
//        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
//
//        static int sharedCount(int c) { // 返回读锁的数量
//            return c >>> SHARED_SHIFT;
//        }
//
//        static int exclusiveCount(int c) { // 返回写锁重入的次数
//            return c & EXCLUSIVE_MASK;
//        }
//
//        protected final boolean tryAcquire(int acquires) { // 写锁最终调用的方法
//            Thread current = Thread.currentThread();
//            int c = getState();
//            int w = exclusiveCount(c); // 代表写锁的数量
//            if (c != 0) { // c != 0有两种情况，既有可能是其他线程加了读锁，也有可能是其他线程加了写锁
//                // w == 0说明加的是读锁，读写互斥，就直接返回false
//                // w != 0，说明加的是写锁，判断一下是不是自己，是就重入，否则返回false
//                if (w == 0 || current != getExclusiveOwnerThread())
//                    return false;
//                if (w + exclusiveCount(acquires) > MAX_COUNT)
//                    throw new Error("Maximum lock count exceeded");
//                // Reentrant acquire
//                setState(c + acquires); // 重入
//                return true;
//            }
//            // writerShouldBlock()涉及到公平非公平的实现，非公平锁总会返回false，公平锁则会先检查队列
//            if (writerShouldBlock() ||
//                    !compareAndSetState(c, c + acquires))
//                return false;
//            setExclusiveOwnerThread(current);
//            return true;
//        }
//
//        protected final int tryAcquireShared(int unused) { // 成功返回1，失败返回-1
//            Thread current = Thread.currentThread();
//            int c = getState();
//            // 判断是不是已经加了写锁了，如果加了写锁，并且加锁的是当前线程，就不会返回-1，会进行锁降级
//            if (exclusiveCount(c) != 0 && getExclusiveOwnerThread() != current)
//                return -1;
//            int r = sharedCount(c);
//            if (!readerShouldBlock() &&
//                    r < MAX_COUNT &&
//                    compareAndSetState(c, c + SHARED_UNIT)) {
//                if (r == 0) {
//                    firstReader = current;
//                    firstReaderHoldCount = 1;
//                } else if (firstReader == current) {
//                    firstReaderHoldCount++;
//                } else {
//                    Sync.HoldCounter rh = cachedHoldCounter;
//                    if (rh == null || rh.tid != getThreadId(current))
//                        cachedHoldCounter = rh = readHolds.get();
//                    else if (rh.count == 0)
//                        readHolds.set(rh);
//                    rh.count++;
//                }
//                return 1;
//            }
//            return fullTryAcquireShared(current);
//        }
//    }
//
//    static final class NonfairSync extends Sync {
//    }
//
//    static final class FairSync extends Sync {
//    }
//
//    public static class ReadLock implements Lock, Serializable {
//        public void lock() {
//            sync.acquireShared(1);
//        }
//    }
//
//    public static class WriteLock implements Lock, Serializable {
//        public void lock() {
//            sync.acquire(1);
//        }
//    }
//
//}