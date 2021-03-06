package wordPlay.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MetricCalculate {
    private String text;
    private String wholeText;
    public static HashMap<String, Integer> wordToFreq;

    public MetricCalculate(String text) {
        this.text = text;
        this.wordToFreq = new HashMap<>();
    }

    /**
     * calculate the average number of words of Per sentence
     * @return average Number of persentence
     */
    public double calAvgNumWordsPerSentence() {
        int length = wholeText.length();
        String[] words = wholeText.split("(?<=\\b|[^\\p{Alpha}])");
       
        int a = calNumOfSentence();
        double avg = 0.00;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i] == "." || words[i] == " " 
                                     || words[i] == "\n") --length;
        }

        avg = length / (double)a;

        return avg;
    }

    /** 
     * calculate the number of sentence according to dot.
     * @param text sentence
     * @return the number of sentence in text
     */
    public int calNumOfSentence() {
        int result = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '.') result++;
        }

        return result;
    }

    /**
     * Average number of characters per sentence(include spaces, including period, excluding
     * newline characters)
     * @return Average number of characters per sentence
     */
    public double calAvgNumCharPerSentence() {
        int length = wholeText.length();
        int a = calNumOfSentence();
        double avg = 0.00;
        
        for(int i = 0; i < wholeText.length(); i++) {
              if(text.charAt(i) == '\n') length--;
        }

        avg = length / a;

        return avg;
    }

    /**
     * Most used word (max frequency)
     * @return most used word
     */
    public String calMaxFreqWord() {
        String[] s = wholeText.split(" ");

        // record the frequence of each word
        for(int i = 0; i < s.length; i++) {
            if(wordToFreq.containsKey(s[i])) {
                Integer a = wordToFreq.get(s[i]);
                wordToFreq.put(s[i],++a);
            } else {
                wordToFreq.put(s[i], 1);
            }
            
        }

        Integer fre = 0;
        String key = "";
        for(Map.Entry m: wordToFreq.entrySet()) {
            if((Integer)m.getValue() > fre) {
                fre = (Integer)m.getValue();
                key = m.getKey().toString();
            }
        }

        return key;
    }

    /**
     * Words with the most number of characters in one sentence.
     * @return the word with the most number of characters in one sentence
     */
    public String calLongestWord() {
        String longestChar = "";
        String[] s = text.split(" ");
        for(int i = 0; i < s.length; i++) {
           if(s[i].length() > longestChar.length()) {
               if(s[i].contains(".")) {
                   longestChar = s[i].substring(0, s[i].length() - 1); 
               } else {
                   longestChar = s[i];
               }

            }
        }

        return longestChar;
    }

    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }



}