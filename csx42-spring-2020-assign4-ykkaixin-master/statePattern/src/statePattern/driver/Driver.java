package statePattern.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import statePattern.Item.Item;
import statePattern.Person.Person;
import statePattern.util.FileProcessor;
import statePattern.util.Results;

/*
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 4) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}")) 
		|| (args[2].equals("${arg2}")) 
		|| (args[3].equals("${arg3}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
			System.exit(0);
		}
		
		 System.out.println(args[2]);
		 String inputFile = args[0];
		 String itemFile = args[1];
		 int windowSize = Integer.parseInt(args[2]);
		 FileProcessor processor = new FileProcessor(inputFile);
		 FileProcessor processor2 = new FileProcessor(itemFile);
		 
		 // add item to hashMap;
		 Item i = new Item();
		 while(true) {
			 String c = processor2.poll();
			 if(c == null) break;
			 String key = processor2.getTheKey(c);
			 String value = processor2.getTheValue(c);
			 i.addItem(value, key);
		 }

		 // get information for inputText and store in result in Reslut
		 Results r = new Results();
		 Person p = new Person(windowSize);
		 String outPutPath = args[3];
		 while(true) {
			String c = processor.poll();
			if(c == null) break;
			 String key = processor.getTheKey(c);
			 String value = processor.getTheValue(c);
			 if(key.equals("money")) {
				 p.getMoney(Integer.parseInt(value));
			 } else if(key.equals("item")) {
				String type = i.getTheType(value);
				boolean canBuy = p.CanBuyItem(type);
				r.setCanBuy(canBuy);
				r.setState(p.getState());
				r.setValue(value);
				r.printTheResult();
				r.fileDisplay(outPutPath);
				System.out.println(p.getState()+"::"+value+"--"+canBuy);
			 }
		 }

		 
	 }

	 @Override
	 public String toString() {
		 // TODO Auto-generated method stub
		 return super.toString();
	 }
}
