package primeDetector.util;

public class CreateWorker {
    private Worker worker;
    private int numThreads;
    private FileProcessor processor;
    private ResultI result;

    public CreateWorker(int numThreads, FileProcessor processor, ResultI result, DataSender sender) {
        this.numThreads = numThreads;
        this.processor = processor;
        this.result = result;
        this.worker = new Worker(this.processor, this.result, sender);
    }

    /**
     * create the worker and start borrow threads from thread pools
     */
    public void startWorker() {
        /**
         * instantiate Thread Pool
         */
        ThreadPool pool = new ThreadPool();
        pool.borrow(numThreads, worker);
        


    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    

}