package numberPlay.util;

import java.io.PrintWriter;
import java.util.ArrayList;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {
	ArrayList<Double> peakArr;
	private String filePath;
	PrintWriter writer;

	public NumberPeaksData(String path) {
		this.peakArr = new ArrayList<>();
		this.filePath = path;
		try {
			this.writer = new PrintWriter(this.filePath);
		} catch(Exception e) {

		}


	}

	@Override
	public void store(Double d) {
		this.peakArr.add(d);
	}

	@Override
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

	@Override
	public void close() {
		try {
			writer.close();
		} catch(Exception e) {

		}
	}

}
