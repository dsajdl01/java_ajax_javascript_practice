package readJSONData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

/**
 *
 * JSONObjectCreater class enable to convert Java Object model into JSON format
 *
 * Class load list of employee and then by using JsonGenerator create JSON array object.
 * Then by using OutputStream and Writer the JSON object is written into JSON file.
 *
 * The exercise is follow from the book RESTFull Java Web Services (second edition)
 * Chapter 2 Java IPAs for JSON Processing page 39 to 40.
 *
 * @author David Sajdl
 *
 */
public class JSONObjectCreater {

	public static void main(String[] args) {

		File dir = new File("/home/david/workspace/RestFullJavaBook/recource");
		if(dir.exists())
		{
			String outputFile = dir.toString() + "/my-emp-array.json";
			new JSONObjectCreater().writeJSONEmployeeList(outputFile);
			List<Employee> empl = new JSONObjectCreater().getEmployeeList();
			empl
			.stream()
			.forEach(e -> System.out.println(e));
			System.out.println("JSON file is ucessfully created!");
		}else
		{
			System.out.println("Incorrect path directory. Please check our path to directory.");
		}

	}

	public void writeJSONEmployeeList(String path){
		// get list of employees
		List<Employee> empList = getEmployeeList();

		try
		{
		        //write to file
		        OutputStream outputStream = new FileOutputStream(path);
		        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
		        /**
		         * JsonGenerator writes JSON to an output source as specified by the
		         * client application. It generates name-value pairs for JSON objects
		         * and values for JSON arrays.
		         */
		        JsonGenerator jsonGenerator = Json.createGenerator(writer);
		        jsonGenerator.writeStartArray();
		        for (Employee empl : empList)
		        {
		            jsonGenerator.writeStartObject()
		                    .write("employeeId", empl.getEmployeeId())
		                    .write("firstName", empl.getEmployeeFirstName())
		                    .write("lastName", empl.getEmployeeLastName())
		                    .write("email", empl.getEmployeeEmail())
		                    .write("hireDate", empl.getEmployeeHireDate().toString())
		                    .writeEnd();

		        }
		        jsonGenerator.writeEnd();
		        writer.flush();

		        // close
		        jsonGenerator.close();
		        writer.close();
		        outputStream.close();

		}
		catch( IOException e)
		{
			e.printStackTrace();
		}
	}

	// creating list of employee
	public List<Employee> getEmployeeList(){
		List<Employee> empList = new ArrayList<Employee>();
		empList.add( new Employee(3001, "David", "Sajdl", "ds@example.com", IsoChronology.INSTANCE.date(2015, 11,26)));
		empList.add( new Employee(3002, "Fred", "Pitt", "fp@example.com", IsoChronology.INSTANCE.date(2013, 11,21)));
		empList.add( new Employee(3003, "Magda", "Best", "mb@example.com", IsoChronology.INSTANCE.date(2015, 01,31)));
		empList.add( new Employee(3004, "Yadira", "Deiz", "yd@example.com", IsoChronology.INSTANCE.date(2014, 10,15)));
		empList.add( new Employee(3005, "Will", "Smith", "ws@example.com", IsoChronology.INSTANCE.date(2012, 12,01)));
		return empList;
	}

}
