import org.json.*;
import java.util.Random;

public class DataMasker {
	
	public static final int ASCII_START = 33;
	public static final int ASCII_END = 126;

	private String jsonData;

	public DataMasker(String data) {

		this.jsonData = data;

	}

	public void setJSON(String data) {

		this.jsonData = data;

	}

	public String getJSON() {

		return this.jsonData;

	}

	public String obfuscate() {

		JSONArray obj = new JSONArray(this.jsonData);

		for (int i = 0; i < obj.length(); i++) {
			JSONObject jsonObject = obj.getJSONObject(i);

			String name =  jsonObject.getString("Name");
			jsonObject.put("Name", alterString(name));

			String address =  jsonObject.getString("Address");
			jsonObject.put("Address", alterString(address));

			String ssn =  jsonObject.getString("SSN");
			jsonObject.put("SSN", alterString(ssn));

			String phone =  jsonObject.getString("Phone");
			jsonObject.put("Phone", alterString(phone));

			String locat =  jsonObject.getString("Location");
			jsonObject.put("Location", alterString(locat));

			String dob =  jsonObject.getString("DOB");
			jsonObject.put("DOB", alterString(dob));

			String email =  jsonObject.getString("Email");
			jsonObject.put("Email", alterString(email));
		}

		return obj.toString();
	}

	public String alterString(String str) {

		int hashCode = str.hashCode();
		Random ranGen = new Random(hashCode);

		String tempStr = "";
		for (int i = 0; i < str.length(); i++) {

			int asciiChar = ranGen.nextInt(ASCII_END - ASCII_START) + ASCII_START;
			char tmpChar = ((char)asciiChar);
			tempStr += tmpChar;

		}

		String shuffled = "";
		for (int i = 0; i < str.length(); i++) {

			int randIndex = ranGen.nextInt(str.length());
			char tmpChar = str.charAt(randIndex);
			shuffled += tmpChar;

		}

		return tempStr + shuffled;

	}

}