
function memberData() 
{

	this.username = "";
	this.firstname = "";
	this.lastname = "";
	this.email = "";
	this.dob = "";
	this.gnd = "";
	this.locat = "";
}

function getProcess()
{
	var isValid = true; 
	var dataVal = [true, true, true, true];
	var memberdata = new Array(1);

	memberdata[0] = new memberData();
	memberdata[0].username = document.getElementById("userName").value.trim();
	memberdata[0].firstname = document.getElementById("firstName").value.trim();
	memberdata[0].lastname = document.getElementById("lastName").value.trim();
	memberdata[0].email = document.getElementById("email").value.trim();
	var confEmail = document.getElementById("emailConf").value.trim();
	memberdata[0].dob = document.getElementById("dob").value.trim();
	var gender = document.getElementById("gender").value;
	memberdata[0].locat = document.getElementById("location").value.trim();
	
	clearErrorMessages();
	
	// vaidata UserName
	if(getValid(memberdata[0].firstname)) {
		isValid = false;
		dataVal[0] = false;
	}

	// validate First name
	if(getValid(memberdata[0].username)) {
		isValid = false;
		dataVal[1] = false;
	} 
	// validate email
	if(validateEmail(memberdata[0].email)){
		if(memberdata[0].email != confEmail){
			isValid = false;
			dataVal[3] = false;
		}
	} else {
		isValid = false;
		dataVal[2] = false;
	}
	// checking genda
	if (gender == "Female") {
		memberdata[0].gnd = "F";
	} else if (gender == "Male") {
		memberdata[0].gnd = "M";
	} else {
		memberdata[0].gnd = null;
	} 

	if(isValid) {
		// send data to database
		window.location.reload(true);
		alert("Data: " + memberdata[0].firstname  + " is successfully added" );
		
	} 
	else 
	{
		var getFocus = true;
		setValueBack(memberdata);

		for(var i = 0; i < dataVal.length; i++)
		{
			if(dataVal[i] == false)
			{
				displayErrorMessage(getFocus, i);
				getFocus = false;
			}

		}
	}

}

function  setValueBack(memberdata)
{
	document.getElementById("firstName").value = memberdata[0].firstname;
	document.getElementById("userName").value = memberdata[0].username;
	document.getElementById("lastName").value = memberdata[0].lastname;
	document.getElementById("email").value = memberdata[0].email;
	document.getElementById("emailConf").value = "";
	document.getElementById("dob").value = memberdata[0].dob;
	document.getElementById("location").value = memberdata[0].locat;
}

function validateEmail(inputText)
{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(inputText.match(mailformat))
	{
		return true;  
	}     
	return false;
} 
function clearErrorMessages()
{
	document.getElementById("firstNameId").innerHTML = "";
	document.getElementById("userNameId").innerHTML = "";
	document.getElementById("emailId").innerHTML = "";
	document.getElementById("emailConfId").innerHTML = "";
}

function displayErrorMessage(focus, index)
{
	if(index == 0)
	{
		document.getElementById("firstName").value = "";
		document.getElementById("firstNameId").innerHTML = "* Entry First Name Please.";
		if(focus)
		{
			document.getElementById("firstName").focus();
			alert("Invalid First name. Please enter First name. \nIt must be greater than 2 characters" );
		}
	}
	if(index == 1)
	{
		document.getElementById("userName").value = "";
		document.getElementById("userNameId").innerHTML = "* Entry User Name Please.";
		if(focus)
		{
			document.getElementById("userName").focus();
			alert("Invalid user name. Please enter user name. \nIt must be greater than 2 characters" );
		}
	}
	if(index == 2)
	{
		document.getElementById("email").value = "";
		document.getElementById("emailConf").value = "";
		document.getElementById("emailId").innerHTML = "* Entry E-mail Address Please.";
		if(focus)
		{
			document.getElementById("email").focus();
			alert("Invalid E-mail Address. Please enter valied E-mail Address.");
		}
	}
	if(index == 3)
	{
		document.getElementById("emailConf").value = "";
		document.getElementById("emailConfId").innerHTML = "* Entry Same E-mail! Please.";
		if(focus)
		{
			document.getElementById("emailConf").focus();
			alert("E-mail Address Does Not Match. \nPlease Entry the Same E-mail Address.");
		}
	}
}

function getValid(tagsVal)
{
    	var tg = tagsVal.replace(/[, ]+/g, " ").trim();
    	tg = tg.replace(/[, ]+/g, " ").trim();
    	return tg.length <= 2;
}



