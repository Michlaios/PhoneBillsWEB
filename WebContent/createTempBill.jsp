<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Νέος πελάτης</title>
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
		<a href="/PhoneBillsWEB/sellermenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">Έκδοση λογιαριασμού πελάτη</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="bill" name="createbill">				
				<div>Εισάγετε τον αριθμό τηλεφώνου του πελάτη:</div><input type="text" name="number" />
				<div>Εισάγετε ημερομηνία (ΜΜ/ΥΥ):</div><input type="text" name="date" />
				<br/>	
				<input type="hidden" name="actionForServletBill" value="temporaryExport"/>	
				<br><br>
				<input type="submit" value="Προσωρινή έκδοση λογαριασμού" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>