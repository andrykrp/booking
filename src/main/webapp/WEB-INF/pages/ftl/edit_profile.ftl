<html>
<head><title>Hotels global booking - User profile</title></head>
<body>
<div id="header">
    <H2>
        index
    </H2>
</div>

<div id="content">
    <table class="profiletable">
        <#assign user = model["user"]>
        <form action="/saveUser" method="post" class="form-horizontal" role="form">
            <input type="hidden" id="id" value="${user.id}" name="id">
        <tr>
            <th>User name: </th>
            <td>
                <input type="text" id="username" value="${user.username}" name="username">
            </td>
        </tr>
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
            <button type="submit" value="Submit" />
            <button type="button" onclick="window.location.replace('/index')" value="Cancel" />
        </tr>
        </form>
    </table>

</div>
</body>
</html>