package statePattern.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class FileProcessor {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String fileName = "/Users/apple/Desktop/input.txt";
        String sentence = null;
        String sentence2 = null;
        String sentence3 = null;
        String sentence4 = "";


		FileProcessor processor = new FileProcessor(fileName);
        sentence = processor.poll();
        sentence2 = processor.poll();
        processor.getTheKey(sentence);
        // sentence3 = processor.readTheFileBySentence();
        // sentence4 = processor.readTheFileBySentence();
        System.out.println(processor.getTheKey(sentence));
        System.out.println(sentence2);
        // System.out.println(sentence3);
        // System.out.println(sentence4.charAt(0) == '\n' && sentence4.length() == 1);
    }
    
    private BufferedReader reader;
	private String line;

	public FileProcessor(String inputFilePath) 
		throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		
		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("invalid input file or input file in incorrect location");
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
	}

    public String poll() throws NumberFormatException, IOException {
		if (null == line) return null;
		
		String newValue = line.trim();
		line = reader.readLine();
		return newValue;
    }
    
    public String getTheKey(String line) throws NumberFormatException, IOException {
        if(null == line) return null;
        String a[] = line.split(":");
        return a[0];
    }

    public String getTheValue(String line) throws NumberFormatException,IOException {
        if(null == line) return null;
        String a[] = line.split(":");
        return a[1];
    }


	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException("failed to close file", e);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    
        
}

