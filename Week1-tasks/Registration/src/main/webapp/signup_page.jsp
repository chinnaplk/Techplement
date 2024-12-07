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
           
      }
</style>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center;">

<h1 style="background-color: blue; color: white; padding: 15px; border-radius: 8px;">Sign Up</h1>

<div style="max-width: 400px; margin: 50px auto; padding: 20px; background: white; box-shadow: 0 0 5px rgba(0,0,0,0.1); border-radius: 8px;">
	<% String message = (String) request.getAttribute("error"); %>
    <h2 style="color: red;"><%= message != null ? message : "" %></h2>
    <form action="SignUp" method="post">
        <label for="username">UserName:</label><br>
        <input type="text" name="username" id="username" required style="padding: 8px; width: 70%; margin: 10px 0; border-radius: 4px; border: 1px solid #ddd;"><br>

        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email" required style="padding: 8px; width: 70%; margin: 10px 0; border-radius: 4px; border: 1px solid #ddd;"><br>

        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password" required style="padding: 8px; width: 70%; margin: 10px 0; border-radius: 4px; border: 1px solid #ddd;"><br>

        <button type="submit" style="padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">Submit</button>
    </form>
</div>

</body>
</html>