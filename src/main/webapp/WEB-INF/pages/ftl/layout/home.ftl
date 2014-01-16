<html>
<head><title>ViralPatel.net - FreeMarker Spring MVC Hello World</title>
<body>
<div id="header">
    <H2>
        home
    </H2>
</div>

<div id="content">
    <table class="datatable">
        <tr>
            <th>Firstname</th>  <th>Lastname</th>
        </tr>
    <#--<#list model["userList"] as user>-->
        <#--<tr>-->
            <#--<td>${user.firstname}</td> <td>${user.lastname}</td>-->
        <#--</tr>-->
    <#--</#list>-->
        <tr>
            <td>${model["message"]}</td>
        </tr>
    </table>

</div>
</body>
</html>