package primeDetector.util;

import java.util.ArrayDeque;
import java.util.Queue;

public class ResultI {
    private int capacity;
    private Queue<Integer> primeQueue; 
    private DataSender sender;

    public ResultI(int capacity,DataSender sender) {
        this.capacity = capacity;
        this.primeQueue = new ArrayDeque<>();
        this.sender = sender;
    }

    /**
     * store the prime in ArrayQueue and send to 
     * server
     * @param a prime
     */
    public void store(int a) throws InterruptedException,IllegalMonitorStateException {
        while(this.primeQueue.size() == capacity) {
            wait();
        }
        
        primeQueue.add(a);
        sender.sendDate(a);
        if(this.primeQueue.size() < capacity - 3) {
            try {
                notifyAll();
            } catch (Exception e) {

            }
        } 
            
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}