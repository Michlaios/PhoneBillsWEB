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
	<title>Κινητή τηλεφωνία | Αποσύνδεση</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<%
		String username = "n/a";
		if (session.getAttribute("username") == null) response.sendRedirect("/PhoneBillsWEB");
		else username = session.getAttribute("username").toString().toUpperCase();
	%>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΑΠΟΣΥΝΔΕΘΗΚΑΤΕ ΕΠΙΤΥΧΩΣ, <%= username %></div>
		<br/><br/>
		<%
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.removeAttribute("property");
			session.invalidate();
		%>
		</td></tr><tr><td class="tdsimple">
		Επιτυχής αποσύνδεση. <a href="/PhoneBillsWEB/login.jsp">Επανασύνδεση!</a>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>