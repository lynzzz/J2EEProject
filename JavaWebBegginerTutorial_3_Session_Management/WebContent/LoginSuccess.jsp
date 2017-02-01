<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
</head>

<body>
<%
Cookie[] cks = request.getCookies();

boolean bHasCookie = false;

if ( cks != null){
for( Cookie ck : cks){
	if ( ck.getName().equals("cookieExample") && ck.getValue().equals("lyn")  ){
		bHasCookie = true;
	}
}
}


if ( !bHasCookie){
	response.sendRedirect("login.html");
}


out.println("Success");

%>


<form action="LogoutServer" method="post">

<input type="submit" value = "logoutButton">


</form>
</body>
</html>