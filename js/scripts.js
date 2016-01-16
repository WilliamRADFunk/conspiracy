function login()
{
	var username = document.getElementById("input_username").value;
	var password = document.getElementById("input_pwd").value;
	if(username !== "" && password !== "")
	{
		document.getElementById("login").style.display = "none";
		document.getElementById("feeds").style.display = "block";
		document.getElementsByTagName("nav")[0].style.display = "block";
	}
}
function register()
{
	console.log("Registering");
}
function seeConspiracy(consp)
{
	console.log("Checking out this conspiracy: " + consp.id);

	document.getElementById("login").style.display = "none";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "block";
}