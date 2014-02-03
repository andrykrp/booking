<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<html>
<script type="text/javascript">
    $( "#saveForm" ).submit(function( event ) {
        var data = $('#saveForm').serialize(); // serialize all the data in the form
        $.ajax({
            url: '/saveUser', // php script to retern json encoded string
            data: data,  // serialized data to send on server
            dataType:'json', // set recieving type - JSON in case of a question
            type:'POST', // set sending HTTP Request type
            async:false,
            success: function(data) { // callback method for further manipulations
                console.log('form send success');
            },
            error: function(data) { // if error occured
                console.log('form send error');
            }
        });
        //event.preventDefault();
        return false;
    });
</script>
<head>
    <title>Hotels global booking - User profile</title>
</head>
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
        <form action="/saveUser" method="post" class="form-horizontal" role="form" id="saveForm">
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
                    <input type="text" id="first_name" name="firstName">
                </td>
            </tr>
        <tr>
            <th>Last name:</th>
            <td>
                <input type="text" id="last_name" name="lastName">
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