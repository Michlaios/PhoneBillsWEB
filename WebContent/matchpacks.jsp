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
		<a href="/PhoneBillsWEB/adminmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΟΛΑ ΤΑ ΠΡΟΓΡΑΜΜΑΤΑ - ΚΛΙΚ ΓΙΑ ΕΠΕΞΕΡΓΑΣΙΑ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="number" name="assignpack">				
				<div>Εισάγετε τον αριθμό τηλεφώνου του πελάτη:</div><input class="righttd td0" type="text" name="number" />
				<div>Εισάγετε το username του πελάτη:</div><input class="righttd td0" type="text" name="clientusername" />
				<br/>
				<table class="tb2">
					<thead>
						<tr>
							<th>Επιλογή πακέτου</th>
							<th>Αναγνωριστικό πακέτου</th>
							<th>Τίτλος πακέτου</th>
							<th>Λεπτά ομιλίας</th>
							<th>Μηνύματα</th>
							<th>Δεδομένα (MiB)</th>
							<th>Κόστος πακέτου</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.pack}" var="s">
							<tr>	
								<td class="td1"><input type="radio" name="idPROGRAMME" value="${s.id}"></td>
								<td class="td1"><c:out value="${s.id}" /></td>
								<td class="td1"><c:out value="${s.title}" /></td>
								<td class="td1"><c:out value="${s.minutes}" /></td>
								<td class="td1"><c:out value="${s.messages}" /></td>
								<td class="td1"><c:out value="${s.data}" /></td>
								<td class="td1"><c:out value="${s.cost}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>		
				<input type="hidden" name="actionForServletNumber" value="matchPack"/>	
				<br><br>
				<input type="submit" value="Αντιστοίχιση" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>