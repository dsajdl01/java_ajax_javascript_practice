package readJSONData;

import java.time.LocalDate;
/**
* Emplyee class
*
* @author David Sajdl
*
*/

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private Integer empId;
	private LocalDate hireDate;

	public void setEmpID(Integer id){
		this.empId = id;
	}
	public void setEmpFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setEmpLastName(String lastName){
		this.lastName = lastName;
	}
	public void setEmpEmail(String email){
		this.email = email;
	}
	public void setEmpHireDate(LocalDate hireDate){
		this.hireDate = hireDate;
	}
	@Override
	public String toString(){
		return "Employee id: "+ this.empId + " | Full name: " + this.firstName + " " + this.lastName
				+ " | E-mail: " + this.email + " | Date of hire: " + this.hireDate;
	}
}
