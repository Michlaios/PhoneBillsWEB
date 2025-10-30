<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Νέο πακέτο</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB/adminmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΔΗΜΙΟΥΡΓΙΑ ΝΕΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="programme" name="addpacket">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Τίτλος προγράμματος: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="45" pattern="[a-zA-Z0-9]+" id="packtitle" name="packtitle" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Λεπτά ομιλίας: </td><td class="righttd td0"><input type="number" min="0" max="99999999999" id="mins" name="mins" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Μηνύματα: </td><td class="righttd td0"><input type="number" min="0" max="99999999999" id="msgs" name="msgs" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Δεδομένα κινητής τηλεφωνίας (MiB): </td><td class="righttd td0"><input type="number" min="0" max="99999999999" id="data" name="data" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Πάγια χρέωση προγράμματος (€): </td><td class="righttd td0"><input type="number" min="0" max="999999999" step="0.01" id="pcost" name="pcost" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
		</table>
		<br/><br/>
		<input type="hidden" name="action" value="addpack" />
		<input type="submit" value="Ολοκλήρωση" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>