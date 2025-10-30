<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Επιτυχία</title>
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
		if (session.getAttribute("property").equals("admin")) forwardlink = "/PhoneBillsWEB/adminmenu.jsp";
		else if (session.getAttribute("property").equals("seller")) forwardlink = "/PhoneBillsWEB/sellermenu.jsp";
		else if (session.getAttribute("property").equals("customer")) forwardlink = "/PhoneBillsWEB/clientmenu.jsp";
	%>
	<br/>
	<table class="tb1">
		<tr><td>
		<h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΣΥΓΧΑΡΗΤΗΡΙΑ!</div>
		<br/><br/>
		</td></tr><tr><td class="tdsimple">
		Επιτυχής εφαρμογή των αλλαγών σας! <a href="<%= forwardlink %>">Επιστροφή στο μενού!</a>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>