package numberPlay.driver;

import numberPlay.subject.*;
import numberPlay.util.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import numberPlay.Filter.*;
import numberPlay.observer.*;

/**
 * @author Kai yi 
 * 
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException,IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 * FIXME Refactor commandline validation using the validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || 
				(args[0].equals("${inputNumStream}")) || 
				(args[1].equals("${runAvgWindowSize}")) || 
				(args[2].equals("${runAvgOutFile}")) ||
				(args[3].equals("${k}")) ||
				(args[4].equals("${topKNumOutFile}")) ||
				(args[5].equals("${numPeaksOutFile}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
		int windowSize = Integer.parseInt(args[1]);
		int dk = Integer.parseInt(args[3]);
		String inputFilePath = args[0];
		String numPeakFilePath = args[5];
		String avgFilePath = args[2];
		String topKFilePath = args[4];

		NumberPeaksData pData = new NumberPeaksData(numPeakFilePath);
		RunningAverageData avgData = new RunningAverageData(avgFilePath);
		TopKNumbersData topKData = new TopKNumbersData(topKFilePath);

		FilterI floatAndDouble = new FloatAndDoubleFilter();
		FilterI intFilter = new IntergerFilter();

		FileProcessor processor = new FileProcessor(inputFilePath);
		NumberProcessor numberProcessor;
		// FIXME Create an instance of each of the classes implementing PersisterI and the 
		// corresponding ResultsI interface.
		// Observers use these objects to dump data to be stored and eventually persisted 
		// to the corresponding output file.

		// FIXME Instantiate the subject.
		SubjectI sub = new NumberGrabber();
		// FIXME Instantiate the observers, providing the necessary filter and the results object.
		ObserverI numPeakOb = new NumberPeaksObserver(sub, floatAndDouble, pData);
		ObserverI topKOb = new TopKNumbersObserver(dk, sub, floatAndDouble, topKData);
		ObserverI avgOb = new RunningAverageObserver(windowSize, sub, intFilter, avgData);
		// FIXME Register each observer with the subject for the necessary set of events.
		
		// FIXME Delegate control to a separate utility class/method that provides numbers one at a time, from the FileProcessor,

		// to the subject.
		String line = "";
		while(line != null) {
			line = processor.poll();
			if(line!= null) {
				numberProcessor = new NumberProcessor(line);

				while(true) {
					String num = numberProcessor.getChar();
					if (num == null) break;
					sub.process(num);
				}
			} else  {
				continue;
			}

		}
		sub.process("COMPLETE");
		processor.close();
	}
}
