<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<div align="center">
		<form action="register.do" method="post">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>User Email</td>
					<td><input type="email" name="email" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>User Mobile Number</td>
					<td><input type="number" name="phnNum" maxlength="40"
						size="40"><br></td>
				</tr>
				<tr>
					<td>User Password</td>
					<td><input type="password" name="password"
						maxlength="20" size="20"><br></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword" maxlength="20"
						size="20"><br></td>
				</tr>
			</table>
			<input type="submit" value="REGISTER">

			<p>
				already have an account <a
					href='login.jsp'>LOGIN</a>
		</form>
	</div>
</body>
</html>