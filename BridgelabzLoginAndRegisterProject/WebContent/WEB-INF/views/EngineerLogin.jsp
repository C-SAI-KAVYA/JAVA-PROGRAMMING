<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Engineer Login </title>
</head>
<body>
<div align="center">
		<h1>Login In</h1>
		<form action = "login" method = "post">
			<table>
				<tr>
					<td>Account User Name</td>
					<td><input type="text" name="LoginUserName" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Account User Password</td>
					<td><input type="text" name="LoginUserPassword" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
				<td><p></p>
				</tr>
				<tr align = "right">
				<td><p>Don't have a account <a href='F:\\BridgeLabzFellowship\\BridgelabzLoginAndRegisterProject\\WebContent\\WEB-INF\\views\\EngineerRegister.jsp'>REGISTER</a> | <a href='F:\\BridgeLabzFellowship\\BridgelabzLoginAndRegisterProject\\WebContent\\WEB-INF\\views\\ResetPassword.jsp'>ForgotPassword??</a></p>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>