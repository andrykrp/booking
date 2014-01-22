<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<html>
<head><title>Hotels global booking</title></head>
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
        index
    </H2>
</div>

<div id="content">
    <table class="datatable">
        <tr>
            <th>Firstname</th>  <th>Lastname</th>  <th>Address</th>  <th>City</th>  <th>Phone No.</th>
        </tr>
    <#--<#list model["userList"] as user>-->
        <#--<tr>-->
            <#--<td>${user.firstname}</td> <td>${user.lastname}</td>-->
        <#--</tr>-->
    <#--</#list>-->
        <tr>
        <!--#list model?keys as key-->
        <#if model["userList"]??>
        <#list model["userList"] as user>
            <!--#assign value = model[key]-->
            <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.city}</td>
            <td>${user.telephone}</td>
            </tr>
        </#list>
        <#else>
        <td colspan=5>No users retrieved from database</td>
        </#if>
    </table>

</div>
</body>
</html>