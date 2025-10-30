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
		<div class="div0">Στοιχεία λογαριασμού</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="bill">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Αριθμός τηλεφώνου πελάτη:</td><td class="righttd td0"><input type="text" value="${requestScope.bill.number}" id="number" name="number" readonly class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Μήνας: </td><td class="righttd td0"><input  readonly value="${requestScope.bill.date}" type="text"  id="date" name="date" class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Συνολικά λεπτά ομιλίας: </td><td class="righttd td0"><input  readonly value="${requestScope.bill.totalDuration/60}" type="number"  id="totalDuration" name="totalDuration" class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Κωδικός προγράμματος:</td><td class="righttd td0"><input type="text" value="${requestScope.bill.programID}" id="packID" name="packID" readonly class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			Πάγια χρέωση: </td><td  class="righttd td0"><input readonly  value="${requestScope.pack.cost}" type="text" id="baseCost" name="baseCost" class="input0" /><br/></td></tr><tr><td class="lefttd0 td0">
			EXTRA χρέωση: </td><td  class="righttd td0"><input readonly  value="${requestScope.bill.extraCost}" type="text" id="extraCost" name="extraCost" class="input0" \/><br/></td></tr><tr><td class="lefttd0 td0">
			Συνολική χρέωση: </td><td  class="righttd td0"><input readonly  value="${requestScope.bill.totalCost}" type="text" id="totalCost" name="totalCost" class="input0" \/><br/></td></tr><tr><td class="lefttd0 td0">
			Εξοφλημένος: </td><td  class="righttd td0"><input readonly value="ΟΧΙ"  type="text" id="paid" name="paid" class="input0" \/><br/></td></tr><tr><td class="lefttd0 td0">
		</table>
		<br/><br/>
		<input type="hidden" name="actionForServletBill" value="createFinalBill"/>
		<input type="submit" value="Οριστική έκδοση λογαριασμού" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>