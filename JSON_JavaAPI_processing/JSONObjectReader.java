package readJSONData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
/**
 * JSONObjectReader class is example of reading JSON file with Object.
 * Then convert JSON Employee object into Java Employee object and store it into memory.
 * Then print all Employee objects.
 *
 * The exercise is follow from the book RESTFull Java Web Services (second edition)
 * Chapter 2 Java IPAs for JSON Processing page 36 to 38.
 *
 * @author David Sajdl.
 *
 */
public class JSONObjectReader {

	public static void main(String[] args) throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		// TODO Auto-generated method stub
		try{

			List<Employee> listEmpl;
			JSONObjectReader jsonReader = new JSONObjectReader();

			//read JSON file
			JsonArray jsonArray = jsonReader.loadJSONData();
			if(jsonArray != null)
			{
				//built employee list
				listEmpl = jsonReader.getEmployeeList(jsonArray);
								//print list
				listEmpl.stream()
					.forEach(e -> System.out.println(e));
			}
			else
			{
				System.out.print("JSON file is emplty!");
			}

		} catch (ParseException pe){
			pe.printStackTrace();
		}

	}

	public List<Employee> getEmployeeList(JsonArray jsonArr) throws ParseException{
		List<Employee> employeeList = new ArrayList<Employee>();
		for(JsonValue jsonVal: jsonArr)
		{
	    /**
             * The JSON data holds array of employee objects, it was used readArray()
             * on JsonReader instance to retrieve the javax.json.JsonArray.
             * JsonArray instance contains an ordered sequence of zero or
             * more object read from the input source.
             *
             * go through readArray and retrieve data and create a new Employee object
             * and populate Employee object with value from readArray.
             * Then store Employee object into list.
             */
			if(jsonVal.getValueType().equals(JsonValue.ValueType.OBJECT))
			{
				JsonObject jsonObject = (JsonObject) jsonVal;
				Employee empl = new Employee();
				empl.setEmpFirstName(jsonObject.getString("firstName"));
				empl.setEmpLastName(jsonObject.getString("lastName"));
				empl.setEmpID(jsonObject.getInt("employeeId"));
				empl.setEmpEmail(jsonObject.getString("email"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date hireDate = dateFormat.parse(jsonObject.getString("hireDate"));
				LocalDate date = hireDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				empl.setEmpHireDate(date);
				employeeList.add(empl);
			}
		}
		return employeeList;
	}

	public JsonArray loadJSONData() throws FileNotFoundException, IOException, org.json.simple.parser.ParseException{

		InputStream inputStream = null;
        JsonReader jsonReader = null;
		try
		{
			// Check if directory exist
			File dir = new File("/home/david/workspace/RestFullJavaBook/recource");
			if(dir.exists())
			{

				// input stream for reading JSON file
				InputStream fis = new FileInputStream(dir.toString()+"/emp-array.json");

				// create JSON reader to read JSON data.
				jsonReader = Json.createReader(fis);

				//create object of readArray and return it
				return jsonReader.readArray();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            if (jsonReader != null) {
	                jsonReader.close();
	            }
	    }
		return null;
	}

}
