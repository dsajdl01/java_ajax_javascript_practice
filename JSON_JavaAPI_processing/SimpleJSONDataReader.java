package readJSONData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * SimpleJSONDataReader class enable to read JSON data and print it out.
 * 
 * It is exercise form following URL:
 * http://www.mkyong.com/java/json-simple-example-read-and-write-json/
 * 
 * @author David Sajdl
 *
 */
public class SimpleJSONDataReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
File dir = new File("/home/david/workspace/RestFullJavaBook");
		
		if( dir.exists()){
			
			JSONParser parser = new JSONParser();

			try {

				Object obj = parser.parse(new FileReader(dir.toString()+"/test.json"));

				JSONObject jsonObject = (JSONObject) obj;
				System.out.print(jsonObject.toString());

				String name = (String) jsonObject.get("name");
				System.out.println(name);

				long age = (Long) jsonObject.get("age");
				System.out.println(age);

				// loop array
				JSONArray msg = (JSONArray) jsonObject.get("messages");
				Iterator<String> iterator = msg.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} else{
			System.out.print(dir.toString() + " does not exist!");
		}

	}

}
