function isEmpty() {
	if (document.forms["form1"]["uid"].value == "" | document.forms["form1"]["pswd"].value == "") {
		alert("Empty Fields");
	}
}