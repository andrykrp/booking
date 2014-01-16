<html>
<head><title>ViralPatel.net - FreeMarker Spring MVC Hello World</title>
<body>
<div id="header">
    <H2>
        index
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
            <td>${model["userList"]}</td>
        </tr>
    </table>

</div>
</body>
</html>