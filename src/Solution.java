import java.util.concurrent.atomic.*;

public class Solution {

    public static void main(String[] args) {
        LockCAS lock = new LockCAS();
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t1 unlock");
            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println("t2 lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t2 unlock");
            }
        });
        t1.start();
        t2.start();

    }

}

class LockCAS {

    AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        state.set(0);
    }

}