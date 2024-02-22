package modifyjasonvalues;

import org.json.JSONObject;
import java.util.Random;
public class JsonUtility{
	
	public static String modifyRandonValuesinJson(String originalJson, String[] keys)
	{
		JSONObject jsonObject = new JSONObject(originalJson);
		
		for(String key : keys)
		{
			Object randomValue = generateRandomValue(jsonObject.get(key));
			jsonObject.put(key, randomValue);
		}
		return jsonObject.toString();
	}
	private static Object generateRandomValue(Object originalValue) {
		Random random = new Random();
		
		if(originalValue instanceof Integer)
		{
			return random.nextInt();
		}
		else if(originalValue instanceof Double)
		{
			return random.nextDouble();
		}
		else if (originalValue instanceof String) {
            return Long.toHexString(Double.doubleToLongBits(Math.random()));
		}
            else {
		// TODO Auto-generated method stub
		return null;
            }
	}
	
	public static void main(String[] args)
	{
		String originalJson= "{\"name\":\"John\",\"age\": 30, \"salary\": 50000.00}";
		String[] keys = {"age","salary"};
		
		String modifiedJson = modifyRandonValuesinJson(originalJson,keys);
		System.out.println("Modified JSON :" + modifiedJson);
	}
}
