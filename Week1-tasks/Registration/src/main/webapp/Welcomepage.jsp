<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;">

<div style="background-color: red; padding: 10px; color: white; display: flex; justify-content: space-between; align-items: center;">
    <a href="loginpage.jsp"><h1 style="margin: 0; font-size: 24px;">Home Page</h1></a>
    <div>
        <a href="loginpage.jsp" style="color: white; text-decoration: none;">Logout</a>
    </div>
</div>

<div style="text-align: center; padding: 20px;">
    <h1 style="color: red;">Welcome to the System!</h1>
    <h2>Your details are:</h2>

    <% 
        String myname = (String) session.getAttribute("name");
        String myemail = (String) session.getAttribute("mail");
        String mypass = (String) session.getAttribute("pwd"); 
    %>

    <h2 style="margin-top: 20px;">Name: <span style="color: blue;"><%= myname %></span></h2>
    <h2>Email: <span style="color: blue;"><%= myemail %></span></h2>
    <h2>Password: <span style="color: blue;"><%= mypass %></span></h2>
</div>

</body>
</html>