<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Σύνδεση</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΣΥΝΔΕΘΕΙΤΕ ΣΤΟ ΛΟΓΑΡΙΑΣΜΟ ΣΑΣ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="login" name="loginform">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Όνομα χρήστη: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" id="loginusername" name="loginusername" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Kωδικός πρόσβασης: </td><td class="righttd td0"><input type="password" minlength="4" maxlength="32" id="loginpassword" name="loginpassword" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Σύνδεση ως: </td><td class="righttd td0"><div class="dropdown0"><button class="btn1" id="dbtn0" disabled="disabled">Πελάτης</button><div class="droplist0" id="droplist0">
			<span class="span0" id="admin" onclick="javascript:set_admin();">Διαχειριστής</span>
			<span class="span0" id="customer" onclick="javascript:set_customer();">Πελάτης</span>
			<span class="span0" id="seller" onclick="javascript:set_seller();">Πωλητής</span>
			</div></div><br/></td></tr>
		</table>
		<br/><br/>
		<input type="hidden" value="customer" id="usrprop" name="usrprop" />
		<input type="submit" value="Σύνδεση" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
	<script type="text/javascript">
		function set_admin() {
			var choice = document.getElementById("dbtn0");
			var prop = document.getElementById("usrprop");
			choice.innerHTML = "Διαχειριστής";
			prop.value = "admin";
			return 0;
		}
		function set_customer() {
			var choice = document.getElementById("dbtn0");
			var prop = document.getElementById("usrprop");
			choice.innerHTML = "Πελάτης";
			prop.value = "customer";
			return 0;
		}
		function set_seller() {
			var choice = document.getElementById("dbtn0");
			var prop = document.getElementById("usrprop");
			choice.innerHTML = "Πωλητής";
			prop.value = "seller";
			return 0;
		}
	</script>
</body>
</html>