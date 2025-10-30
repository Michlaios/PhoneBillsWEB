<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Νέος πωλητής</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<%
		String username = "n/a";
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		if (session.getAttribute("username") == null) response.sendRedirect("/PhoneBillsWEB/login.jsp");
		else username = session.getAttribute("username").toString().toUpperCase();
	%>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB/adminmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΕΓΓΡΑΦΗ ΝΕΟΥ ΠΩΛΗΤΗ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="seller" name="addseller" onsubmit="javascript:return check_input();">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Όνομα: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="sellername" name="sellername" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επώνυμο: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="sellersurname" name="sellersurname" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Username: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" id="sellerusername" pattern="[a-zA-Z0-9]+" name="sellerusername" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Νέος κωδικός πρόσβασης: </td><td class="righttd td0"><input type="password" minlength="4" maxlength="32" id="sellerpassword" name="sellerpassword" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επανάληψη κωδικού πρόσβασης: </td><td class="righttd td0"><input type="password" id="sellerpassword2" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Email: </td><td class="righttd td0"><input type="email" id="selleremail" name="selleremail" class="input0" required="required"/><br/></td></tr>
		</table>
		<br/><br/>
		<input type="submit" value="Εγγραφή" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
	<script type="text/javascript">
		function check_input() {
			var password = document.getElementById("sellerpassword").value;
			var password2 = document.getElementById("sellerpassword2").value;
			var errors = "Οι κωδικοί πρόσβασης δεν ταιριάζουν!";
			if (password != password2) {
				alert(errors);
				return false;
			}
			return true;
		}
	</script>
</body>
</html>