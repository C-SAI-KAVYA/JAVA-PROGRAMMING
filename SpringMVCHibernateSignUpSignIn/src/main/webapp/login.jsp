<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<div align="center">
		<h1>Login In</h1>
		<form action = "login.do" method = "post">
			<table>
				<tr>
					<td>User Email</td>
					<td><input type="text" name="email" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>User Login Password</td>
					<td><input type="password" name="password" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
				<td><input type = "submit" value = "Login"></td>
				</tr>
				<tr align = "right">
				<td><p>Don't have a account <a href='register.jsp'>REGISTER</a> | <a href='forgot.jsp'>ForgotPassword??</a></p>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>