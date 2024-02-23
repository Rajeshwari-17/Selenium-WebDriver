package jsonmodifications;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonDataProcessor {
	
	public static void main(String[] args)
	{
		
		JSONParser parser  = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\Downloads\\Sample.json"));
			JSONObject jsonobject = (JSONObject) obj;
			
			String name = (String) jsonobject.get("name");
			String age =  (String) jsonobject.get("age");
			
			 System.out.println("Name: " + name);
	            System.out.println("Age: " + age);
		}catch(IOException | ParseException e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
