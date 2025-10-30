<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Επεξεργασία πακέτου</title>
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
		<div class="div0">ΤΡΟΠΟΠΟΙΗΣΗ ΥΠΑΡΧΟΝΤΟΣ ΠΡΟΓΡΑΜΜΑΤΟΣ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="programme" name="editpacket">
		<table class="tb2"><tr><td class="lefttd0 td0">
			Αναγνωριστικό προγράμματος: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="20" value="${pack.id}" id="viewid" name="viewid" class="input0" required="required" disabled="disabled"/><br/></td></tr><tr><td class="lefttd0 td0">
			Τίτλος προγράμματος: </td><td class="righttd td0"><input type="text" minlength="1" maxlength="45" value="${pack.title}" id="packtitle" pattern="[a-zA-Z0-9]+" name="packtitle" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Λεπτά ομιλίας: </td><td class="righttd td0"><input type="number" min="0" max="99999999999" value="${pack.minutes}" id="mins" name="mins" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Μηνύματα: </td><td class="righttd td0"><input type="number" min="0" max="99999999999" value="${pack.messages}" id="msgs" name="msgs" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Δεδομένα κινητής τηλεφωνίας (MiB): </td><td class="righttd td0"><input type="number" min="0" max="99999999999" value="${pack.data}" id="data" name="data" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
			Κόστος προγράμματος (€): </td><td class="righttd td0"><input type="number" min="0" max="999999999" step="0.01" value="${pack.cost}" id="pcost" name="pcost" class="input0" required="required"/><br/></td></tr><tr><td class="lefttd0 td0">
		</table>
		<br/><br/>
		<input type="hidden" name="packid" value="${pack.id}" />
		<input type="hidden" name="action" value="editpack" />
		<input type="submit" value="Ολοκλήρωση" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>