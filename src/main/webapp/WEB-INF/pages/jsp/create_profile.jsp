<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../../resources/jquery/1.10/jquery.js" ></script>
    <script>
        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

        $( document ).ready(function() {
            console.log("document loaded");
            $( "#saveForm" ).submit(function( event ) {
                var data = JSON.stringify($('form').serializeObject());
                console.log(data);
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    contentType: "application/json; charset=UTF-8",
                    url: '/registerUser?retypePassword=' + $('#retypePassword').val(), // php script to retern json encoded string
                    data: data,  // serialized data to send on server
                    dataType:'json', // set recieving type - JSON in case of a question
                    type:'POST', // set sending HTTP Request type
                    async:false,
                    success: function(data) { // callback method for further manipulations
                        console.log('form send success');
                        window.location = "/";
                    },
                    error: function(jqXHR, textStatus, errorThrown) { // if error occured
                        console.log(textStatus);
                        console.log('form send error');
                    }
                });
                //event.preventDefault();
                return false;
            });
        });
    </script>
    <title>Hotels global booking - Registration form</title>
</head>
<body>
<p>You are currently logged in as: ${user.firstName} ${user.lastName}.
    <a href="/j_spring_security_logout">Logout</a>.</p>

<div id="header">
    <H2>
        Please edit your personal profile
    </H2>
</div>

<div id="content">
    <table class="profiletable">
        <form action="/registerUser" method="post" class="form-horizontal" role="form" id="saveForm">
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
                <td><input type="submit" value="Submit" /></td>
                <td><input type="button" onclick="window.location.replace('/index')" value="Cancel" /></td>
            </tr>
        </form>
    </table>

</div>

</body>
</html>