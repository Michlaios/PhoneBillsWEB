<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Νέος διαχειριστής</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΕΓΓΡΑΦΗ ΝΕΟΥ ΔΙΑΧΕΙΡΙΣΤΗ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="admin" name="addadmin" onsubmit="javascript:return check_input();">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Όνομα: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="adminname" name="adminname" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επώνυμο: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="adminsurname" name="adminsurname" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Username: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[a-zA-Z0-9]+" id="adminusername" name="adminusername" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Νέος κωδικός πρόσβασης: </td><td class="righttd td0"><input type="password" minlength="4" maxlength="32" pattern="[a-zA-Z0-9]{4}[a-zA-Z0-9]*" id="adminpassword" name="adminpassword" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επανάληψη κωδικού πρόσβασης: </td><td class="righttd td0"><input type="password" id="adminpassword2" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Email: </td><td class="righttd td0"><input type="email" id="adminemail" name="adminemail" class="input0" required="required"/><br/></td></tr>
		</table>
		<br/><br/>
		<input type="submit" value="Εγγραφή" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
	<script type="text/javascript">
		function check_input() {
			var password = document.getElementById("adminpassword").value;
			var password2 = document.getElementById("adminpassword2").value;
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