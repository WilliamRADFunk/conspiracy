function login()
{
	var username = document.getElementById("input_username").value;
	var password = document.getElementById("input_pwd").value;
	if(username !== "" && password !== "")
	{
		document.getElementById("login").style.display = "none";
		document.getElementById("feeds").style.display = "block";
	}
}
function register()
{

}