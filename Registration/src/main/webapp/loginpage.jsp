<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	label {
            text-align: left;
            display: block;
            
        }
      input{
      		text-align: left;
            display: block;
</style>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center;">

<h1 style="background-color: blue; color: white; padding: 15px; border-radius: 8px;">WELCOME TO THE APPLICATION</h1>

<div style="max-width: 400px; margin: 50px auto; padding: 20px; background: white; box-shadow: 0 0 5px rgba(0,0,0,0.1); border-radius: 8px;">
    <% String message = (String) request.getAttribute("error"); %>
    <h2 style="color: red;"><%= message != null ? message : "" %></h2>

    <h3>Login</h3>
    <form action="login" method="post">
        <label>Email: </label><br>
        <input type="email" name="email" required style="padding: 8px; width: 70%; margin: 0px; border-radius: 4px; border: 1px solid #ddd;"><br>

        <label>Password: </label><br>
        <input type="password" name="password" required style="padding: 8px; width: 70%; margin: 0px; border-radius: 4px; border: 1px solid #ddd;"><br>

        <button type="submit" style="padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">Login</button>
    </form>

    <p>If you don't have an account, please Sign Up <a href="signup_page.jsp" style="color: #007bff;">Sign Up</a></p>
</div>

</body></html>