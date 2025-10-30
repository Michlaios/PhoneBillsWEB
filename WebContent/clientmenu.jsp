<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Κινητή τηλεφωνία | Μενού</title>
	<link rel="stylesheet" type="text/css" href="index.css" />
</head>
<body>
	<%
		String username = "n/a";
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("/index.jsp");
		}else{

		if(!session.getAttribute("property").equals("customer"))
		{		
			
			session.removeAttribute("username"); 		
			session.invalidate();
			request.setAttribute("msg","Access to page denied, you were logged out for security reasons.");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request,response);
		}
		}
		username = session.getAttribute("username").toString().toUpperCase();
	%>
	<br/>
	<table class="tb1">
		<tr><td>
		<a href="/PhoneBillsWEB/clientmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΚΑΛΩΣ ΟΡΙΣΑΤΕ, <%= username %></div>
		<br/><br/>
		</td></tr><tr><td class="tdsimple">
		Επιτυχής σύνδεση!
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Διαχείριση λογαριασμών" onclick="javascript:location.href='/PhoneBillsWEB/listbills.jsp';" />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Ανανέωση υπολοίπου" onclick="javascript:location.href='/PhoneBillsWEB/client?action=loadmoney';" />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Προβολή ιστορικού κλήσεων" onclick="javascript:location.href='/PhoneBillsWEB/listCalls.jsp';"  />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Αποσύνδεση" onclick="javascript:location.href='/PhoneBillsWEB/logout.jsp';" />
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>