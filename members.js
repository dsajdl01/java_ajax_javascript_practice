
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

function getProcess(){
	var isValid = true;
	var memberdata = new Array(1);
	alert("Data pass 11");
	memberdata[0] = new memberData();

	memberdata[0].username = document.getElementById("userName").value.trim();
	memberdata[0].firstname = document.getElementById("firstName").value.trim();
	memberdata[0].lastname = document.getElementById("lastName").value.trim();
	memberdata[0].email = document.getElementById("email").value.trim();
	var confEmail = document.getElementById("emailConf").value.trim();
	memberdata[0].dob = document.getElementById("dob").value.trim();
	var gender = document.getElementById("gender").value;
	memberdata[0].loct = document.getElementById("location").value.trim(); 
	
//	window.location.reload(true);

	// validate First name
	if(getValid(memberdata[0].username)) {
		//getFocusOnField(memberdata, 0);
		isValid = false;
	} 

	
	// vaidata UserName
	if(getValid(memberdata[0].firstname)) {
		//getFocusOnField(memberdata, 1);
		isValid = false;
	}
	// validate email
	if(validateEmail(memberdata[0].email)){
		alert(memberdata[0].email + " == " + confEmail + " is: " + (memberdata[0].email != confEmail));
		if(memberdata[0].email != confEmail){
			isValid = false;
		}
	} else {
		isValid = false;
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
		alert("Data: " + memberdata[0].firstname  + " is successfully added" );
	} 
}

function validateEmail(inputText) {  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(inputText.match(mailformat)) {
		return true;  
	}     
	return false;
} 

function getFocusOnField(usersData, f){
	if(f == 0){
		document.getElementById("EntryUserName").value = "";
		document.getElementById("EntryUserName").focus();
		alert("Invalid user name. Please enter user name." );
	}
}

function getValid(tagsVal){
    	var tg = tagsVal.replace(/[, ]+/g, " ").trim();
    	tg = tg.replace(/[, ]+/g, " ").trim();
    	//alert(tg.length <= 1);
    	return tg.length <= 2;
}



