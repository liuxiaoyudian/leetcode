//public class Main1 {
//
//    // ㈠ 可打断的获取锁流程
//    private void doAcquireInterruptibly(int arg) throws InterruptedException {
//        final Node node = addWaiter(Node.EXCLUSIVE);
//        boolean failed = true;
//        try {
//            for (; ; ) {
//                final Node p = node.predecessor();
//                if (p == head && tryAcquire(arg)) {
//                    setHead(node);
//                    p.next = null; // help GC
//                    failed = false;
//                    return;
//                }
//                if (shouldParkAfterFailedAcquire(p, node) &&
//                        parkAndCheckInterrupt()) {
//                    // 在 park 过程中如果被 interrupt 会进入此
//                    // 这时候抛出异常, 而不会再次进入 for (;;)
//                    throw new InterruptedException();
//                }
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node);
//        }
//    }
//
//}
