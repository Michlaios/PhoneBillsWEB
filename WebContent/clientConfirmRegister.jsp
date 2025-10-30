<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="div0">Προσθήκη νέου πελάτη</div>
		<br/><br/>
		</td></tr><tr><td>
		<form method="post" action="client" name="addClient">
		<table class="tb2">
			<tr><td class="lefttd0 td0">
			Αριθμός μητρώου πελάτη: </td><td class="righttd td0"><input type="text" value="<c:out value='${sessionScope.clienttaxnumber}' />" id="clienttaxnumber" name="clienttaxnumber" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			Όνομα: </td><td class="righttd td0"><input type="text" value="<c:out value='${sessionScope.clientname}' />" id="clientname" name="clientname" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			Επώνυμο: </td><td class="righttd td0"><input type="text" value="<c:out value='${sessionScope.clientsurname}' />"  id="clientsurname" name="clientsurname" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			Όνομα χρήστη: </td><td class="righttd td0"><input type="text" value="<c:out value='${sessionScope.clientusername}' />" id="clientusername" name="clientusername" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			<input type="hidden" value="<c:out value='${sessionScope.clientpassword}' />" name="password"/>
			Email: </td><td class="righttd td0"><input type="email"  value="<c:out value='${sessionScope.clientemail}' />" id="clientemail" name="clientemail" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			Αριθμός κινητού: </td><td class="righttd td0"><input type="text" value="${requestScope.number}"  id="number" name="number" class="input0" readonly/><br/></td></tr><tr><td class="lefttd0 td0">
			Επιλεγμένο πακέτο: </td><td class="righttd td0"><input type="text" value="${requestScope.idPROGRAMME}"  id="chosenpack" name="chosenpack" class="input0" readonly/><br/></td></tr>
			
		</table>
		<br/><br/>
		<input type="submit" value="Εγγραφή πελάτη" id="submit" class="btn0" />
		</form>
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>