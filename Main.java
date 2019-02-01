import org.json.*;
import java.io.*;
import org.apache.commons.io.FileUtils;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("names/names.csv"));
			String line = "";
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> names2 = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {

				DataMasker masker = new DataMasker();
				String thing = masker.alterString(line);
				if (names.contains(thing)) {
					System.out.println("ono____________________" + thing + " " + line + " " + names2.contains(line));
					// break;
				}
				names.add(thing);
			}
		}catch(Exception e) {

		}

		// if (args.length == 1) {

		// 	try {

		// 		String jsonData = FileUtils.readFileToString(new File(args[0]));
		// 		DataMasker obfuscator = new DataMasker(jsonData);

		// 		System.out.println(obfuscator.obfuscate());

		// 	} catch (IOException e) {

		// 		e.printStackTrace();

		// 	}

		// } else {

		// 	System.out.println("Error: wrong number of arguments");

		// }

	}

}