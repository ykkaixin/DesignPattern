package numberPlay.util;

import java.io.FileWriter;
import java.util.ArrayList;

public class RunningAverageData implements PersisterI, RunningAverageResultsI {
	ArrayList<Double> avgArr;
	String outPutPath;
	FileWriter writer;

	public RunningAverageData(String outPutPath) {
		this.avgArr = new ArrayList<>();
		try {
			writer = new FileWriter(outPutPath);
		} catch(Exception e) {
			System.out.println("file path wrong");
		}
	}
	@Override
	public void store(Double d) {
		avgArr.add(d);
	}

	@Override
	public void writeToFile() {
		for(int i = 0; i < avgArr.size();i++) {
			try {
				String str = avgArr.get(i).toString();
				writer.write(str);
				writer.write("\n");
			} catch (Exception e) {
				System.out.println("avg number write failed");
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
