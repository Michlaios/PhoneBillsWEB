<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Αρχική</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
<script type="text/javascript">
    var msg = "<%= request.getAttribute("message") %>";
    var user="<%= request.getAttribute("user") %>";
    if (msg=="Wrong Password!" || msg=="There is no user with the username: "+user+", please enter a valid username!" || msg=="There is already a user with the username: "+user+", please enter a different username." )
    	{
    	Swal.fire({
    		  icon: 'error',
    		  title: 'Oops...',
    		  text: msg
    		})

    	}    
</script>
	<br/>
	<table class="tb1">
	<tr><td>
	<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
	<br/><br/>
	</td></tr><tr><td>
	<div class="div0">ΚΑΛΩΣ ΟΡΙΣΑΤΕ!</div>
	<br/><br/>
	</td></tr><tr><td>
	<img class="img0" src="./phone.png" />
	<br/><br/>
	</td></tr><tr><td>
	<input type="button" onclick="javascript:location.href='/PhoneBillsWEB/login.jsp';" value="Σύνδεση στο λογαριασμό σας" class="btn0" />
	<br/>
	</td></tr><tr><td>
	<input type="button" onclick="javascript:location.href='/PhoneBillsWEB/adminregister.jsp';" value="Εγγραφή νέου διαχειριστή" class="btn0" />
	<br/><br/>
	</td></tr>
	</table>
</body>
</html>