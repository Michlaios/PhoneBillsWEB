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
		<a href="/PhoneBillsWEB/clientmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΟΛΟΙ ΟΙ ΛΟΓΑΡΙΑΣΜΟΙ - ΚΛΙΚ ΓΙΑ ΛΕΠΤΟΜΕΡΕΙΕΣ</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="get" action="bill" name="listbills">
		<div>Εισάγετε τον αριθμό τηλεφώνου σας:</div><input type="text" name="number" />
		<input type="hidden" name="action" value="listbills"/>	
		<input type="submit" value="Εμφάνιση ιστορικού" id="submit" class="btn0" />
		</form>
			<table class="tb2">
				<thead>
					<tr>
						<th>Αναγνωριστικό λογαριασμού</th>
						<th>Εξοφλημένος</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.bill}" var="s">
						<tr>
							<td class="td1"><a href="/PhoneBillsWEB/bill?action=showbill&amp;billID=<c:out value='${s.billID}' />"><c:out value="${s.billID}" /></a></td>
							<td class="td1"><c:out value="${s.paid}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/><br/>
		</td></tr>
	</table>
</body>
</html>