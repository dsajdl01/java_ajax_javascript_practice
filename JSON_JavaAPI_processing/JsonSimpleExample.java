package readJSONData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * SimpleJSONExample class enable to create JSON data and 
 * Store created JSON data into text.json file.
 * 
 * It is exercise form following URL:
 * http://www.mkyong.com/java/json-simple-example-read-and-write-json/
 * 
 * @author David Sajdl
 *
 */
public class JsonSimpleExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File dir = new File("/home/david/workspace/RestFullJavaBook");
		
		if( dir.exists()){
			JSONObject obj = new JSONObject();
			obj.put("name", "mkyong.com");
			obj.put("age", new Integer(100));
	
			JSONArray list = new JSONArray();
			list.add("msg 1");
			list.add("msg 2");
			list.add("msg 3");
	
			obj.put("messages", list);
	
			try {
	
				FileWriter file = new FileWriter(dir.toString()+"/test.json");
				file.write(obj.toJSONString());
				file.flush();
				file.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			System.out.print(obj);
		} else {
			System.out.print(dir.toString() + " does not exist!");
	     }
	}

}
