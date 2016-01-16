function login()
{
	var username = document.getElementById("input_username").value;
	var password = document.getElementById("input_pwd").value;
	if(username !== "" && password !== "")
	{
		document.getElementById("login").style.display = "none";
		document.getElementById("logout").style.display = "block";
		document.getElementById("feeds").style.display = "block";
		document.getElementsByTagName("nav")[0].style.display = "block";
	}
}
function logout()
{
	document.getElementById("input_username").value = "";
	document.getElementById("input_pwd").value = "";
	document.getElementById("login").style.display = "block";
	document.getElementById("logout").style.display = "none";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("profile").style.display = "none";
	document.getElementsByTagName("nav")[0].style.display = "none";
}
function register()
{
	console.log("Registering");

	document.getElementById("login").style.display = "none";
	document.getElementById("register").style.display = "block";
}
function submitRegistration()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("feeds").style.display = "block";
	document.getElementsByTagName("nav")[0].style.display = "block";
}
function seeConspiracy(consp)
{
	console.log("Checking out this conspiracy: " + consp.id);

	document.getElementById("login").style.display = "none";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "block";
}
function share()
{
	console.log("Sharing is caring");
}