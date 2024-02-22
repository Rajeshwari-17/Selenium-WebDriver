package fetchdatafromjson;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {

	public static JSONObject readJsonFile(String filePath) {
		JSONParser parser = new JSONParser();
		JSONObject jsonData = null;
		try {
			Object obj = parser.parse(new FileReader(filePath));
			jsonData = (JSONObject) obj;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return jsonData;
	}

	public static void displayJsonContent(JSONObject jsonData) {
		System.out.println("JSON Content:");
		System.out.println(jsonData.toJSONString());
	}

	public static void main(String[] args) {
        
        String filePath = "C:\\Users\\Admin\\Downloads\\example_1.json"; // replace with the actual path to your JSON file

        
        JSONObject jsonData = readJsonFile(filePath);
        
        displayJsonContent(jsonData);

        
    }
}