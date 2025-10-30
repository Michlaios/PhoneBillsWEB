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
	<title>Κινητή τηλεφωνία | Νέος πελάτης</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">Προσθήκη νέου πελάτη</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="client"  onsubmit="javascript:return check_input();">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Αριθμός τηλεφώνου πελάτη:</td><td class="righttd td0"><input type="text" value="${requestScope.pack}" id="number" name="number" readonly class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Αριθμός μητρώου πελάτη: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[a-zA-Z0-9]+" id="clienttaxnumber" name="clienttaxnumber" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Όνομα: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="clientname" name="clientname" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επώνυμο: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[α-ω΄΄Α-Ωa-zA-Z]+" id="clientsurname" name="clientsurname" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Όνομα χρήστη: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="16" pattern="[a-zA-Z0-9]+" id="clientusername" name="clientusername" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Νέος κωδικός πρόσβασης: </td><td class="righttd td0"><input type="password" minlength="4" maxlength="32" pattern="[a-zA-Z0-9]{4}[a-zA-Z0-9]*" id="clientpassword" name="clientpassword" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Επανάληψη κωδικού πρόσβασης: </td><td class="righttd td0"><input type="password" id="adminpassword2" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Email: </td><td class="righttd td0"><input type="email" id="clientemail" name="clientemail" class="input0" required="required"/><br/></td></tr>
		</table>
		<br/><br/>
		<input type="hidden" name="actionForServletNumber" value="addNumber"/>
		<input type="hidden" name="actionForServletClient" value="addClient"/>
		<input type="hidden" name="idPROGRAMME" value="1718545573233"/>
		<input type="submit" value="Eπόμενο" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
	<script type="text/javascript">
		function check_input() {
			var password = document.getElementById("clientpassword").value;
			var password2 = document.getElementById("clientpassword2").value;
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