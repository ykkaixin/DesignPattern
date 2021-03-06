package wordPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileProcessor {
    public static void main(String[] args) {
        String fileName = "/home/kai/Desktop/input.txt";
        String sentence = null;
        String sentence2 = null;
        String sentence3 = null;
        String sentence4 = "";


		FileProcessor processor = new FileProcessor(fileName);
		processor.openFile();
        sentence = processor.readTheFileBySentence();
        sentence2 = processor.readTheFileBySentence();
        sentence3 = processor.readTheFileBySentence();
        sentence4 = processor.readTheFileBySentence();
        System.out.println(sentence);
        System.out.println(sentence2);
        System.out.println(sentence3);
        System.out.println(sentence4.charAt(0) == '\n' && sentence4.length() == 1);
    }
    
    private String fileName;
    private InputStreamReader reader;
    private InputStream inStream;
    private BufferedReader bufferReader;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    /**
     * open the File 
     * @return
     */
    public void openFile()  {
        try {
            if(fileName == "") {throw new Exception("input file is empty");}
            this.inStream = new FileInputStream(fileName);
            this.reader = new InputStreamReader(inStream);
            this.bufferReader = new BufferedReader(reader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * read the file by sentence 
     * @return return the Sentence end by .
     */
    public String readTheFileBySentence() {
        StringBuilder sentence = new StringBuilder();
        try {
            int tempchar;
            while((tempchar = bufferReader.read()) != -1) {
                if((char) tempchar != '\r') {
                    sentence.append((char)tempchar);
                }
                if((char)tempchar == '.') {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sentence.toString();
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
        
}

