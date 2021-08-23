//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.LockSupport;
//
//public class ReentrantLock implements Lock {
//
//    private final Sync sync;
//
//    abstract static class Sync extends AbstractQueuedSynchronizer {
//
//        final boolean nonfairTryAcquire(int acquires) {
//            final Thread current = Thread.currentThread();
//            int c = getState();
//            if (c == 0) {
//                if (compareAndSetState(0, acquires)) {
//                    setExclusiveOwnerThread(current);
//                    return true;
//                }
//            } else if (current == getExclusiveOwnerThread()) {
//                int nextc = c + acquires;
//                if (nextc < 0) // overflow
//                    throw new Error("Maximum lock count exceeded");
//                setState(nextc);
//                return true;
//            }
//            return false;
//        }
//
//    }
//
//    static final class NonfairSync extends Sync {
//
//        final void lock() {
//            if (compareAndSetState(0, 1))
//                setExclusiveOwnerThread(Thread.currentThread());
//            else // 加锁失败后就会进入这个方法
//                acquire(1); // 是AQS中的方法
//        }
//
//        protected final boolean tryAcquire(int acquires) {
//            return nonfairTryAcquire(acquires);
//        }
//
//        // 注意这个是AQS中的方法，放在这里只是为了方便阅读源码
//        public final void acquire(int arg) {
//            // 再尝试进行一次加锁，如果加锁失败就会进入这个if块，即可能需要加入等待队列中进行等待了
//            if (!tryAcquire(arg) &&
//                    acquireQueued(addWaiter(Node.EXCLUSIVE), arg)) // 会尝试创建一个Node对象，并加入到等待队列中去
//                selfInterrupt();
//        }
//
//        // AQS中的方法
//        final boolean acquireQueued(final Node node, int arg) {
//            boolean failed = true;
//            try {
//                boolean interrupted = false;
//                for (; ; ) {
//                    final Node p = node.predecessor(); // 获取前驱结点
//                    // 如果p == head，就说明该node紧邻着head（排第二位），此时就会再次尝试获取锁
//                    if (p == head && tryAcquire(arg)) {
//                        setHead(node);
//                        p.next = null; // help GC
//                        failed = false;
//                        return interrupted;
//                    }
//                    // shouldParkAfterFailedAcquire会将前驱node的waitStatus改为-1，然后返回false。
//                    // // 如果其前驱node已经是-1了，则返回true
//                    // -1代表，该node有责任唤醒它的后继node
//                    if (shouldParkAfterFailedAcquire(p, node) &&
//                            parkAndCheckInterrupt())
//                        interrupted = true;
//                }
//            } finally {
//                if (failed)
//                    cancelAcquire(node);
//            }
//        }
//
//        // AQS中的方法
//        private final boolean parkAndCheckInterrupt() {
//            LockSupport.park(this);
//            return Thread.interrupted();
//        }
//
//    }
//
//    static final class FairSync extends Sync {
//    }
//
//    public ReentrantLock() { // 默认非公平锁
//        sync = new NonfairSync();
//    }
//
//    public ReentrantLock(boolean fair) { // 为true就是公平锁
//        sync = fair ? new FairSync() : new NonfairSync();
//    }
//
//    @Override
//    public void lock() {
//        sync.lock();
//    }
//
//    @Override
//    public void lockInterruptibly() throws InterruptedException {
//
//    }
//
//    @Override
//    public boolean tryLock() {
//        return false;
//    }
//
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        return false;
//    }
//
//    @Override
//    public void unlock() {
//
//    }
//
//    @Override
//    public Condition newCondition() {
//        return null;
//    }
//}
//
