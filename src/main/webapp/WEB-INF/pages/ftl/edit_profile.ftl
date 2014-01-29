<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<html>
<head><title>Hotels global booking - User profile</title></head>
<body>
<@security.authentication property="principal" var="loginData" scope="page" />
<#if .globals.loginData?is_hash_ex && .globals.loginData.username??>
    <p>You are currently logged in as ${.globals.loginData.username}.
        <a href="/j_spring_security_logout">Logout</a>
    <br>To edit your personal data please proceed to <a href="/userProfile">your profile page</a>.</p>
<#elseif .globals.loginData?is_string && .globals.loginData == "anonymousUser">
    <p>You are not logged in. Please proceed to <a href="/spring_security_login">Login page</a></p>
</#if>

<div id="header">
    <H2>
        Please edit your personal profile, username ${.globals.loginData.username}
    </H2>
</div>

<div id="content">
    <table class="profiletable">
        <#assign user = model["user"]>
        <form action="/saveUser" method="post" class="form-horizontal" role="form">
        <tr>
            <th>First name:</th>
            <td>
                <input type="text" id="firstName" value="${user.firstName}" name="firstName">
            </td>
        </tr>
        <tr>
            <th>Last name:</th>
            <td>
                <input type="text" id="lastName" value="${user.lastName}" name="lastName">
            </td>
        </tr>
        <tr>
            <th>Address: </th>
            <td>
                <input type="text" id="address" value="${user.address}" name="address">
            </td>
        </tr>
        <tr>
            <th>City: </th>
            <td>
                <input type="text" id="city" value="${user.city}" name="city">
            </td>
        </tr>
        <tr>
            <th>Telephone No.:</th>
            <td>
                <input type="text" id="telephone" value="${user.telephone}" name="telephone">
            </td>
        </tr>
        <tr>
            <td><button type="submit" value="Submit" /></td>
            <td><button type="button" onclick="window.location.replace('/index')" value="Cancel" /></td>
        </tr>
        </form>
    </table>

</div>
</body>
</html>