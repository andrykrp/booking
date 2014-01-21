<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<html>
<head><title>Hotels global booking</title></head>
<body>
<div id="header">
    <H2>
        index
    </H2>
</div>

<@security.authentication property="principal.username" var="name" scope="page" />

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

    You are currently logged in as ${.globals.name}.
    <#if model["logged_in_user"]??>
        <p>You are currently logged in as ${requestParameters.servicesettings}.
        To edit your personal data please proceed to <a href="/userProfile/${model["logged_in_user"].username}">user profile page</a>.</p>
    <#else>
        <p>You are not logged in. Please proceed to <a href="/login">Login page</a></p>
    </#if>

</div>
</body>
</html>