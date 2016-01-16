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
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
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
function rate(id)
{
	document.getElementById("star-1").removeAttribute("class");
	document.getElementById("star-2").removeAttribute("class");
	document.getElementById("star-3").removeAttribute("class");

	if(id === "1")
	{
		document.getElementById("star-" + id).className = "chosen";
	}
	else if(id === "2")
	{
		document.getElementById("star-1").className = "chosen";
		document.getElementById("star-" + id).className = "chosen";
	}
	else
	{
		document.getElementById("star-1").className = "chosen";
		document.getElementById("star-2").className = "chosen";
		document.getElementById("star-" + id).className = "chosen";
	}
	// TODO: Query the rating to the database.
}
function goHome()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "block";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
}
function makePost()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "block";
}
function submitPost()
{
	console.log("Makin' a pooooost");
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "block";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
}