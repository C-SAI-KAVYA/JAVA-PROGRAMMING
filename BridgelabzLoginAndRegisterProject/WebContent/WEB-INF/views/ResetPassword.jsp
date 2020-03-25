<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
<div align="center">
		<h1>Login In</h1>
		<form action = "reset" method = "post">
			<table>
				<tr>
					<td><p>please enter the new password</p></td>
					<td><input type="text" name="New Password" maxlength="20"
						size="20" placeholder="New Password"><br></td>
				</tr>
				<tr>
					<td><p>confirm your new password</p></td>
					<td><input type="text" name="Confirm New Password" maxlength="20"
						size="20" placeholder = "Confirm New Password"><br></td>
				</tr>
				<tr>
				<td><p><a href='F:\\BridgeLabzFellowship\\BridgelabzLoginAndRegisterProject\\WebContent\\WEB-INF\\views\\EngineerLogin.jsp'>Cancel</a></p>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>