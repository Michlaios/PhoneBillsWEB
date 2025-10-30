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

		if(!session.getAttribute("property").equals("admin"))
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
		<a href="/PhoneBillsWEB/adminmenu.jsp"><h2>Εφαρμογή έκδοσης και διαχείρισης λογαριασμών κινητής τηλεφωνίας</h2></a>
		<br/><br/>
		</td></tr><tr><td>
		<div class="div0">ΚΑΛΩΣ ΟΡΙΣΑΤΕ, <%= username %></div>
		<br/><br/>
		</td></tr><tr><td class="tdsimple">
		Επιτυχής σύνδεση!
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Προσθήκη νέου πωλητή" onclick="javascript:location.href='/PhoneBillsWEB/sellerregister.jsp';" />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Δημιουργία νέου προγράμματος" onclick="javascript:location.href='/PhoneBillsWEB/programme?action=addpack';" />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Τροποποίηση υπάρχοντος προγράμματος" onclick="javascript:location.href='/PhoneBillsWEB/programme?action=listpacks';" />
		<br/><br/>
		</td></tr><tr><td>
		<input type="button" class="btn0" value="Αποσύνδεση" onclick="javascript:location.href='/PhoneBillsWEB/logout.jsp';" />
		<br/><br/>
		</td></tr>
	</table>
</body>
</html>