<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Ουπς...</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΔΥΣΤΥΧΩΣ ΑΣΤΟΧΗΣΑΜΕ!</div>
		<br/><br/>
		</td></tr><tr><td class="tdsimple">
		Προέκυψε ένα σφάλμα κατά την είσοδό σας στο σύστημα. <a href="/PhoneBillsWEB/login.jsp">Δοκιμάστε ξανά!</a>
		<br/><br/>
		Λεπτομέρειες σφάλματος:
		<br/>
		<%= request.getAttribute("err") %>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>