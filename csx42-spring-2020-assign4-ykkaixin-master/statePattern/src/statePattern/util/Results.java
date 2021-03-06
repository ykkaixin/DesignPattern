package statePattern.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String resultText = "";
    private boolean canBuy;
    private String value;
    private String state;

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

    public void setResultText(String result) {
        this.resultText = result;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void printTheResult() {
        String b;
        if(this.canBuy) {
            b = "YES";
        } else {
            b = "NO";
        }
        String out = String.format("%s::%s--%s\n", this.state, this.value, b);
        resultText = out;
    }

    public void setCanBuy(boolean c) {
        this.canBuy = c;
    }

    public void setValue(String v) {
        this.value = v;
    }

    public void setState(String s) {
        this.state = s;
    }
}
