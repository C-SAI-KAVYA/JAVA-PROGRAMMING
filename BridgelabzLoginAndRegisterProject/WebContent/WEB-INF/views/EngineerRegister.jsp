<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Engineer Registration Page</title>
<script>
	function myFunction() {
		var x = document.getElementById("myInput");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h1>Register Here</h1>
		<h5>fill the details below</h5>
		<form action="register" method="post">
			<table>
				<tr>
					<td>Engineer ID</td>
					<td><input type="text" name="ID" maxlength="20" size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer First Name</td>
					<td><input type="text" name="FirstName" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer Last Name</td>
					<td><input type="text" name="LastName" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer Date Of Birth</td>
					<td><input type="date" name="dateOfBirth" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer Email ID</td>
					<td><input type="email" name="UserEmailID" maxlength="40"
						size="40"><br></td>
				</tr>
				<tr>
					<td>Engineer Address</td>
					<td><input type="text" name="UserAddress" maxlength="50"
						size="50"><br></td>
				</tr>
				<tr>
					<td>Engineer Mobile Number</td>
					<td><input type="number" name="MobileNumber" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer YOP</td>
					<td><input type="number" name="YOP" maxlength="20" size="20"><br></td>
				</tr>
				<tr>
					<td>Engineer Branch</td>
					<td><input type="text" name="branch" maxlength="20" size="20"><br></td>
				</tr>

				<tr>
					<td>Engineer Aggregate</td>
					<td><input type="number" name="aggregate" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Account User Name</td>
					<td><input type="text" name="LoginUserName" maxlength="20"
						size="20"><br></td>
				</tr>
				<tr>
					<td>Account User Password</td>
					<td><input type="password" name="LoginUserPassword"
						maxlength="20" size="20" id="myInput"><br></td>
					<td><input type="checkbox" onclick="myFunction()">Show
						Password</td>
				</tr>
			</table>
			<input type="submit" value="REGISTER">

			<p>
				already have an account <a
					href='F:\\BridgeLabzFellowship\\BridgelabzLoginAndRegisterProject\\WebContent\\WEB-INF\\views\\EngineerLogin.jsp'>LOGIN</a>
		</form>
	</div>
</body>
</html>