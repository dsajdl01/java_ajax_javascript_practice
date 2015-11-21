package readJSONData;

import java.time.LocalDate;
/**
* Employee class
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

	public Employee(){
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.empId = 0;
		this.hireDate = null;
	}

	public Employee(Integer empId, String firstname, String lastname, String email, LocalDate hiredate){
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.empId = empId;
		this.hireDate = hiredate;
	}
	// setters
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
	// getters
	public Integer getEmployeeId(){
		return this.empId;
	}
	public String getEmployeeFirstName(){
		return this.firstName;
	}
	public String getEmployeeLastName(){
		return this.lastName;
	}
	public String getEmployeeEmail(){
		return this.email;
	}
	public LocalDate getEmployeeHireDate(){
		return this.hireDate;
	}

	@Override
	public String toString(){
		return "Employee id: "+ this.empId + " | Full name: " + this.firstName + " " + this.lastName
				+ " | E-mail: " + this.email + " | Date of hire: " + this.hireDate;
	}
}
