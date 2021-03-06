package numberPlay.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {
	List<List<Double>> topArr;
	PrintWriter writer;
	String filePath;

	public TopKNumbersData(String path) {
		this.filePath = path;
		this.topArr = new ArrayList<List<Double>>();
		try {
			this.writer = new PrintWriter(this.filePath);
		} catch(Exception e){

		};
	}

	@Override
	public void store(List<Double> topK) {
		//this.topArr.add(topK);
		List<Double> topk = new ArrayList<>();
		for(int i = 0; i < topK.size(); i++) {
			topk.add(topK.get(i));
		}
		this.topArr.add(topk);
	}

	@Override
	public void writeToFile() {
		for(int i = 0; i < topArr.size(); i++) {
			try{
				String str = topArr.get(i).toString();
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
