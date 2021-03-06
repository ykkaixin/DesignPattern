package primeDetector.util;

// import java.util.Set;
// import java.util.concurrent.ArrayBlockingQueue;
// import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    // private int taskNum = 50;

    // private Set<WorkThread> workThreads;
    // private BlockingQueue<Runnable> taskQueue;

    public ThreadPool() {
        // taskQueue = new ArrayBlockingQueue<>(taskNum);
        // workThreads = new HasSet<>();
    }

    /**
     * borrow thread 
     * @param workNum number of borrow
     * @param worker the task
     */
    public void borrow(int workNum, Runnable worker) {
        for(int i = 0; i < workNum; i++) {
            //new Thread(worker).start();
            new Thread(worker).start();;
        }

    }

    // public execute(Runnable task) {
    //     try {
    //         taskQueue.put(task);
    //     } catch(InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    // private class WorkThread extends Thread {
    //     public WorkThread(String name) {
    //         super();
    //         setName(name);
    //     }

    //     @Override
    //     public void run() {
    //         while(!(interrupted())) {
    //             try {
    //                 Runnable thread = taskQueue.take();
    //                 if(thread != null) {
    //                     thread.run();
    //                 }
    //             } catch (Exception e) {
    //                 interrupt();
    //                 e.printStackTrace();
    //             }
    //         }

    //     }

    //     public void stopWork() {
    //         interrupt();
    //     }
    // }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}