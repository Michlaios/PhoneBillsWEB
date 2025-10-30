<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Όλα τα πακέτα</title>
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
			<table class="tb2">
				<thead>
					<tr>
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
							<td class="td1"><a href="/PhoneBillsWEB/programme?action=editpack&amp;idPROGRAMME=<c:out value='${s.id}' />"><c:out value="${s.id}" /></a></td>
							<td class="td1"><c:out value="${s.title}" /></td>
							<td class="td1"><c:out value="${s.minutes}" /></td>
							<td class="td1"><c:out value="${s.messages}" /></td>
							<td class="td1"><c:out value="${s.data}" /></td>
							<td class="td1"><c:out value="${s.cost}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/><br/>
		</td></tr>
	</table>
</body>
</html>