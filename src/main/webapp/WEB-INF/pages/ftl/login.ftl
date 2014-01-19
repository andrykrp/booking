<html>
<head>
<title>Hotels global booking - Login Page</title>
</head>
<body onload='document.login_form.username.focus();'>

    <#if model["login_error_msg"]??>
        <p><h3 color="red">Login attempt failed for the following reason: ${model["login_error_msg"]}<b>
        Please try again</h3></p>
    </#if>
	<p><h3>Login with Username and Password</h3></p>
 
	<form name='login_form' action="/login" method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='userId' id='userId' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' id='password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="reset" type="reset" />
				</td>
			</tr>
		</table>
 
	</form>
</body>
</html>