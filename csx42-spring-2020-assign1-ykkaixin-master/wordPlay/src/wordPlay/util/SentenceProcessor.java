package wordPlay.util;

import java.util.Stack;

public class SentenceProcessor {
    private String sentence;

    public SentenceProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * reverse the Sentence
     * @return the reversed sentence
     */
    public String reverseSentence() {
        String[] words = sentence.split("(?<=\\b|[^\\p{Alpha}])");
        for(int i = 0; i < words.length; i++) {
            words[i] = reverseWord(words[i]);
        }
        return String.join("", words);
    }

    /**
     * reverse the word
     * @param word each word which need reverse
     * @return return the reversed word
     */
    public String reverseWord(String word) {
        StringBuilder reverseWord = new StringBuilder();
        Stack<Character> wordSta = new Stack<Character>();
        char[] wordArr = word.toCharArray();
        
        for(int i = 0; i < wordArr.length; i++) {
            wordSta.add(wordArr[i]);
        }
        for(int i = 0; i < wordArr.length; i++) {
            reverseWord.append(wordSta.pop());
        }
        
        return reverseWord.toString();

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
