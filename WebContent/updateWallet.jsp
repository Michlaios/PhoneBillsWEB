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
	<title>Κινητή τηλεφωνία | Νέος πελάτης</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">Ανανέωση υπολοίπου</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="client" name="addmoney">				
				<table class="tb2">
			<tr><td class="lefttd0 td0">
			Υπόλοιπο λογαριασμού:</td><td class="righttd td0"><input type="text" value="${requestScope.money}$" id="number" name="number" readonly class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Προσθέστε υπόλοιπο: </td><td class="righttd td0"><input type="number"  id="money" name="money" class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
		</table>
				<input type="hidden" name="actionForServletClient" value="updateMoney"/>	
				<br><br>
				<input type="submit" value="Ανανέωση υπολοίπου" id="submit" class="btn0" />
		</form>
</body>
</html>