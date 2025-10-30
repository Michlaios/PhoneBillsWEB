<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Ιστορικό κλήσεων</title>
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
		<a href="/PhoneBillsWEB/clientmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">Ιστορικό κλήσεων</div>
		<br/><br/>
		<form method="get" action="calls" name="listCalls">				
				<div>Εισάγετε τον αριθμό τηλεφώνου σας:</div><input type="text" name="number" />
				<div>Εισάγετε ημερομηνία (ΜΜ/ΥΥ):</div><input type="text" name="date" />
				<br/>	
				<input type="hidden" name="action" value="listCalls"/>	
				<br><br>
				<input type="submit" value="Εμφάνιση ιστορικού" id="submit" class="btn0" />
		</form>
		</td></tr><tr><td>
			<table class="tb2">
				<thead>
					<tr>
						<th>Αναγνωριστικό κλήσης</th>
						<th>Διάρκεια κλήσης</th>
						<th>Ημερομηνία κλήσης</th>
						<th>Πρόγραμμα τηλεφωνίας</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.call}" var="s">
						<tr>
							<td class="td1"><c:out value="${s.callID}" /></td>
							<td class="td1"><c:out value="${s.callDuration}" /></td>
							<td class="td1"><c:out value="${s.callDate}" /></td>
							<td class="td1"><c:out value="${s.packID}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/><br/>
		</td></tr>
	</table>
</body>
</html>