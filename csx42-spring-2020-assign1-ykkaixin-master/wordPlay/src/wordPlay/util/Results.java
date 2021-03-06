package wordPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private static double avgWordsPerSentence;
    private static double avgNumCharPerSentence;
    private static String maxFreqWord;
    private static String longestWord;
    private String resultText = "";

    @Override
    public void fileDisplay(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.append(resultText);
            bWriter.close();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        } 

    }

    


    @Override
    public void printTheResult() {
        System.out.format("AVG_NUMBER_WORDS_PER_SENTENCE = %.2f\n", avgNumCharPerSentence);
        System.out.format("AVG_NUM_CHARS_PER_SENTENCE = %.2f\n", avgWordsPerSentence);
        System.out.format("MAX_FREQ_WORD = %s\n", maxFreqWord);
        System.out.format("LONGEST_WORD = %s", longestWord);

    }

    public void setAvgWordsPerSentence(double avg) {
        this.avgWordsPerSentence = avg;
    }

    public void setAvgNumCharPerSentence(double avgN) {
        this.avgNumCharPerSentence = avgN;
    }

    public void setMaxFreqWord(String maxFreqWord) {
        this.maxFreqWord = maxFreqWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord =  longestWord;
    }
    
 

    public void setResultText(String result) {
        this.resultText = result;
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }



    

}
