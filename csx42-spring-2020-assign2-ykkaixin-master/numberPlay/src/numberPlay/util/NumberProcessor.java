package numberPlay.util;


public class NumberProcessor {
    private String line;
    String[] wordArr;
    private int numberOfWord = 1;

    public NumberProcessor(String line) {
        this.line = line;
        wordArr = this.line.split(" ", 0);
    };

    /**
     * get the one word of line
     * @return each word in one line
     */
    public String getChar() {
        int index = numberOfWord - 1;
        if(numberOfWord > wordArr.length) return null;

        if (wordArr.length == 1) {
            numberOfWord++;
            return wordArr[index];
        }
        return wordArr[index];
    }
}