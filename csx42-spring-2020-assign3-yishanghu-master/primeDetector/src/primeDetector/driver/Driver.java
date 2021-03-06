package primeDetector.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;


import primeDetector.util.CreateWorker;
import primeDetector.util.DataSender;
import primeDetector.util.DataSenderClient;
import primeDetector.util.FileProcessor;
import primeDetector.util.ResultI;

/**
 * @author Kai yi
 * 
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		/**
		 * create an instance of CreateWorkers and pass and instance of the
		 * FileProcessor, Result, isPrime to the constructor of CreateWorkers.
		 * CreateWorkers invoke the method startWorkers() and pass NUM_THREADS as an
		 * argument
		 * 
		 * CreateWorkers a = CreateWorkers(FileProcessor,Result,IsPrime)
		 * a.startWorkers(NUM_THREADS);
		 */

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used FIXME Refactor commandline validation using the
		 * validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputNumStream}"))
				|| (args[1].equals("${numThreads}")) || (args[2].equals("${capacity}"))
				|| (args[3].equals("${persisterServiceIp}")) || (args[4].equals("${persisterServicePort}"))
				|| (args[5].equals("${debugValue}"))) {
            System.out.println(args[0] + args[1] + args[2] + args[3] + args[4] + args[5]);
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
		String filePath = args[0];
		int capacity = Integer.parseInt(args[2]);
		int numberThreads = Integer.parseInt(args[1]);
		String ipAddress = args[3];
		int port = Integer.parseInt(args[4]);
		String debugValue = args[5];
		FileProcessor processor = new FileProcessor(filePath);

		// FIXME Create an instance of each of the classes implementing PersisterI and
		// the
		// corresponding ResultsI interface.
		InetAddress ip = InetAddress.getByName("localhost");
		DataSender sender = new DataSenderClient(ip, port);
		ResultI r = new ResultI(capacity, sender);
		CreateWorker w = new CreateWorker(numberThreads, processor, r, sender);
		w.startWorker();
		
		
	}
}
