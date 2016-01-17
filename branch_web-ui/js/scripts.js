var parse;
var currentUser;
function init()
{
	Parse.initialize("6tAJZkpgW9kdlJhQmv1BF5TMq8weUwEaNTYE1WKp", "42UHDmrJLF6ZQrt9I016j6WmjKtEY74uT2DaRXWZ");
}
function login()
{
	var name = document.getElementById("input_username").value;
	var pwd = document.getElementById("input_pwd").value;

	Parse.User.logIn(name, pwd,
	{
		success: function(results)
		{
			loginCall(true);
		},
		error: function(error)
		{
			loginCall(false);
		}
	});
}
function loginCall(victory)
{
	if(victory)
	{
		document.getElementById("login").style.display = "none";
		document.getElementById("logout").style.display = "block";
		document.getElementById("about").style.display = "none";
		document.getElementById("feeds").style.display = "block";
		populateFeeds();
		document.getElementsByTagName("nav")[0].style.display = "block";
		currentUser = Parse.User.current();
	}
	else
	{
		document.getElementById("input_username").value = "";
		document.getElementById("input_pwd").value = "";
		alert("That username or password is not in our records.");
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
	document.getElementById("about").style.display = "none";
	document.getElementsByTagName("nav")[0].style.display = "none";
	Parse.User.logOut();
}
function register()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("register").style.display = "block";
}
function submitRegistration()
{
	var name = document.getElementById("input_reg-username").value;
	var pwd = document.getElementById("input_reg-pwd").value;
	var email = document.getElementById("input_reg-email").value;

	var user = new Parse.User();
	user.set("username", name);
	user.set("password", pwd);
	user.set("email", email);

	user.signUp(null,
	{
		success: function(user)
		{
			registrationCall(true);
		},
		error: function(user, error)
		{
			registrationCall(false);
		}
	});
}
function registrationCall(victory)
{
	if(victory)
	{
		document.getElementById("login").style.display = "block";
		document.getElementsByTagName("nav")[0].style.display = "block";
	}
	else
	{
		alert("You entered invalid data, or left a field empty.");
	}
}
function populateListView(consp)
{
	//console.log(consp);
	/*var Conspiracies = Parse.Object.extend("Conspiracies");
	var query = new Parse.Query(Conspiracies);

	//query.descending("viewCount");
	query.find({
		success: function(results)
		{
			populateFeedsCall(true, results);
		},

		error: function(error)
		{
			populateFeedsCall(false);
		}
	});
	*/
	document.getElementById("login").style.display = "none";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "block";
	//populateListView(consp);
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
	populateFeeds();
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
	document.getElementById("about").style.display = "none";
}
function makePost()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "block";
	document.getElementById("about").style.display = "none";
}
function submitPost()
{
	var title = document.getElementById("input_title").value;
	var synopsis = document.getElementById("input_synopsis").value;
	/*var proof = document.getElementById("btn_proof").files[0];
	if (proof)
    {
    	fileReader = new FileReader();
    	fileReader.readAsDataURL(proof);
    }
    else
    {
    	alert("File failed to upload!");
    }*/

	var Post = Parse.Object.extend("Conspiracies");
	var post = new Post();

	if(currentUser !== null)
	{
		post.set("user", currentUser);
		post.set("title", title);
		post.set("description", synopsis);
		//post.set("photo", proof);

		post.save(null,
		{
			success: function(post)
			{
				submitPostCall(true);
			},
			error: function(post, error)
			{
				 submitPostCall(false);
			}
		});
	}
	else
	{
		document.getElementById("input_title").value = "";
		document.getElementById("input_synopsis").value = "";
		document.getElementById("input_proof").value = "";
		logout();
		alert("You are not logged in!");
	}
}
function submitPostCall(victory)
{
	if(victory)
	{
		document.getElementById("login").style.display = "none";
		document.getElementById("logout").style.display = "block";
		document.getElementById("feeds").style.display = "block";
		populateFeeds();
		document.getElementById("list-view").style.display = "none";
		document.getElementById("settings").style.display = "none";
		document.getElementById("post").style.display = "none";
		document.getElementById("about").style.display = "none";
	}
	else
	{
		alert("You entered one or more fields with invalid data, or failed to fill out an important field.");
	}
	
}
function goSettings()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "block";
	document.getElementById("post").style.display = "none";
	document.getElementById("about").style.display = "none";
}
function submitSettingsChange()
{
	var username = document.getElementById("input_name").value;
	var password = document.getElementById("input_pass").value;
	var email = document.getElementById("input_email").value;
	var file = document.getElementById("input_file-avatar").value;

	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "block";
	populateFeeds();
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
	document.getElementById("about").style.display = "none";
}
function populateFeeds()
{
	var Conspiracies = Parse.Object.extend("Conspiracies");
	var query = new Parse.Query(Conspiracies);
	
	query.find({
		success: function(results)
		{
			populateFeedsCall(true, results);
		},

		error: function(error)
		{
			populateFeedsCall(false);
		}
	});
}
function populateFeedsCall(victory, results)
{
	document.getElementById("feeds").innerHTML = "";
	if(victory)
	{	
		for(var i = 0; i < results.length; i++)
		{
			var object = results[i];
			var ident = object.get("objectId");
			document.getElementById("feeds").innerHTML += '<div id="' + ident + '"' +
			'class="feed" onclick="populateListView(this)"><div class="img_main-evidence">' +
			'<img src="images/placeholder.jpg" height="200px" width="200px"></div>' +
			'<div class="feed-content"><h3>' + object.get("title") + '</h3>' +
			'<p class="author">Author: <span>' + object.get("username") + '</span></p>' +
			'<p class="details">Conspirators: <span>  ' + object.get("conspirator_count") + '  </span>' +
			'Comments: <span>  ' + object.get("commentCount") + '  </span></p></div></div>';
		}
	}
	else
	{
		alert("There was a problem retrieving conspiracies from the database. It seems the suits are trying to silence us.");
	}
}
function goAbout()
{
	document.getElementById("login").style.display = "none";
	document.getElementById("logout").style.display = "block";
	document.getElementById("feeds").style.display = "none";
	document.getElementById("list-view").style.display = "none";
	document.getElementById("settings").style.display = "none";
	document.getElementById("post").style.display = "none";
	document.getElementById("about").style.display = "block";
}