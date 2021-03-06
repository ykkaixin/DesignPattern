package primeDetector.util;

import java.io.IOException;

public class Worker implements Runnable {
    private FileProcessor processor;
    private ResultI result;
    private DataSender sender;

    public Worker(FileProcessor processor, ResultI result, DataSender sender) {
        this.processor = processor;
        this.result = result;
        this.sender = sender;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(this) {
                try {
                    String p = processor.poll();
                    if(p == null) {
                        sender.endOfFile("STOP");
                        break;
                    }

                    try {
                        int num = Integer.parseInt(p);
                        boolean isPrime = isPrime(num);
                        //System.out.println(num);
                        if (isPrime) {
                            result.store(num);
                        }
                    } catch(Exception e) {
                        System.out.println("the number in file must be int");
                    }

                } catch ( NumberFormatException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * judge number is prime
     * @param number input number of file
     * @return true is prime false is not prime
     */
    private boolean isPrime(int number) {

        boolean flag = true;
 
		if (number < 2) {
			return false;
		} else {
 
			for (int i = 2; i <= Math.sqrt(number); i++) {
 
				if (number % i == 0) {
 
					flag = false;
					break;
				}
			}
		}
		return flag;
    }
}