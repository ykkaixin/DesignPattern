package primeDetector.PersisterService;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrimeData{
	ArrayList<Integer> peakArr;
	private String filePath;
	FileWriter writer;

	public PrimeData(String path) {
		this.peakArr = new ArrayList<>();
		this.filePath = path;
		try {
            this.writer = new FileWriter(path);

		} catch(Exception e) {

		}


	}

	public void store(int d) {
		this.peakArr.add(d);
	}

	public void writeToFile() {
		for(int i = 0; i < peakArr.size(); i++) {
			try {
				String str = peakArr.get(i).toString();
				writer.write(str);
				writer.write("\n");
			} catch(Exception e) {

			}
		}
	}

	public void close() {
		try {
			writer.close();
		} catch(Exception e) {

		}
	}

}
