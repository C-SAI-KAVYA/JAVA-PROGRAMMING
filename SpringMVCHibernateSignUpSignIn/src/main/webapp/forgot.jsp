<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<div align="center">
		<h1>Login In</h1>
		<form action = "forgot.do" method = "post">
			<table>
				<tr>
					<td><p>please enter the Email ID</p></td>
					<td><input type="text" name="UserName" maxlength="20"
						size="20" placeholder="UserName"><br></td>
				</tr>
				<tr>
					<td><p>New Password</p></td>
					<td><input type="text" name="NewPassword" maxlength="20"
						size="20" placeholder = "NewPassword"><br></td>
				</tr>
				<tr>
					<td><input type = "submit" value = "RESET"></td>
				</tr>
				<tr>
				<td><p><a href='login.jsp'>GoBackToLogin</a></p>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>