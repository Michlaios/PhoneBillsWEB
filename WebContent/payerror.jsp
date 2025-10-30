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
	<%
		String username = "n/a", forwardlink = "/PhoneBillsWEB/actionerror.jsp";
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		if (session.getAttribute("username") == null) response.sendRedirect("/PhoneBillsWEB/login.jsp");
		else username = session.getAttribute("username").toString().toUpperCase();
		if (session.getAttribute("property").equals("customer")) forwardlink = "/PhoneBillsWEB/updateWallet.jsp";
	%>
	<br/>
	<table class="tb1">
		<tr><td>
		<h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">Το υπολοιπό σας δεν επαρκεί για  την εξόφληση του λογιαριασμού σας!</div>
		<br/><br/>
		</td></tr><tr><td class="tdsimple">
		Ανανανεώστε το υπόλοιπό σας εδώ: <a href="<%= forwardlink %>">Ανανεώστε το υπόλοιπό σας!</a>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>