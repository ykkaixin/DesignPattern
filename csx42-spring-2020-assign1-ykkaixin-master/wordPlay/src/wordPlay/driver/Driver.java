package wordPlay.driver;
import wordPlay.util.*;

/*
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}")) || (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		} else {
			System.out.println("Hello World! Lets get started with the assignment");
			String fileName = args[0];
			String outputFile = args[1];
			String metricFile = args[2];
			String sentence = null;
			String reversedSentence = null;
			String longest = "";
			StringBuilder wholeText = new StringBuilder();
			Results results = new Results();
			
			FileProcessor processor = new FileProcessor(fileName);
			processor.openFile();

			while(true) {
				sentence = processor.readTheFileBySentence();
				if(sentence.charAt(0) == '\n' && sentence.length() == 1) break;
				
				wholeText.append(sentence);
				SentenceProcessor senProcessor = new SentenceProcessor(sentence);
				reversedSentence = senProcessor.reverseSentence();

				//results = new Results();
				results.setResultText(reversedSentence);
				results.fileDisplay(outputFile);

				MetricCalculate cal = new MetricCalculate(sentence);
				if(cal.calLongestWord().length() > longest.length()) {
					longest = cal.calLongestWord();
					results.setLongestWord(longest);
				}
			}
			String text = wholeText.toString();
			MetricCalculate cal = new MetricCalculate(text);
			cal.setWholeText(text);
			results.setAvgNumCharPerSentence(cal.calAvgNumCharPerSentence());
			results.setAvgWordsPerSentence(cal.calAvgNumWordsPerSentence());
			results.setMaxFreqWord(cal.calMaxFreqWord());
			results.fileDisplay(metricFile);
			results.printTheResult();
		}
	}
}
