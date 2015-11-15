function getProcess(){
	var isValid = true;
	var usersData = new Array(7);

	usersData[0] = document.getElementById("userName").value;
	usersData[1] = document.getElementById("firstName").value;
	usersData[2] = document.getElementById("lastName").value;
	usersData[3] = document.getElementById("email").value;
	usersData[4] = document.getElementById("dob").value;
	usersData[5] = document.getElementById("gender").value;
	usersData[6] = document.getElementById("location").value;

	window.location.reload(true);

	if(getValid(usersData[0])) {
		getFocusOnField(usersData, 0);
		isValid = false;
	} 

	if(getValid(usersData[1])) {
		getFocusOnField(usersData, 1);
		isValid = false;
	}
	
	if(isValid) {
		
		alert("Data " + usersData + " was successfully added" );
	} 
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



