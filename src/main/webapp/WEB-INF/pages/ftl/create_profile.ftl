<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<html>
<head><title>Hotels global booking - User profile</title></head>
<body>
<@security.authentication property="principal" var="loginData" scope="page" />
<#if .globals.loginData?is_hash_ex && .globals.loginData.username??>
    <p>You are already logged in as ${.globals.loginData.username}. Please
        <a href="/j_spring_security_logout">logout</a>
        or edit your personal data please proceed to <a href="/userProfile">your profile page</a>.</p>
<#elseif .globals.loginData?is_string && .globals.loginData == "anonymousUser">
<div id="header">
    <H2>
        Please fill out and submit the following form of your personal profile
    </H2>
</div>

<div id="content">
    <table class="profiletable">
        <form action="/saveUser" method="post" class="form-horizontal" role="form">
            <tr>
                <th>E-Mail (username):</th>
                <td>
                    <input type="text" id="username" name="username">
                </td>
            </tr>
            <tr>
                <th>Please enter password:</th>
                <td>
                    <input type="password" id="password" name="password">
                </td>
            </tr>
            <tr>
                <th>Please re-type password:</th>
                <td>
                    <input type="password" id="retypePassword" name="retypePassword">
                </td>
            </tr>
            <tr>
                <th>First name:</th>
                <td>
                    <input type="text" id="firstName" name="firstName">
                </td>
            </tr>
        <tr>
            <th>Last name:</th>
            <td>
                <input type="text" id="lastName" name="lastName">
            </td>
        </tr>
        <tr>
            <th>Address: </th>
            <td>
                <input type="text" id="address" name="address">
            </td>
        </tr>
        <tr>
            <th>City: </th>
            <td>
                <input type="text" id="city" name="city">
            </td>
        </tr>
        <tr>
            <th>Telephone No.:</th>
            <td>
                <input type="text" id="telephone" name="telephone">
            </td>
        </tr>
        <tr>
            <td><button type="submit" value="Submit" /></td>
            <td><button type="button" onclick="window.location.replace('/index')" value="Cancel" /></td>
        </tr>
        </form>
    </table>
</#if>

</div>
</body>
</html>