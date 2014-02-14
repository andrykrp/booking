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
                var pswd = $('#password').val();
                console.log('Password:'+pswd);
                var pswd2 = $('#retypePassword').val();
                console.log('Password 2:'+pswd2);
                if(pswd !== pswd2) {
                    $('#error_text').html("Please correct the following errors:");
                    $('#retype_password_error').html("Passwords do not match");
                    return false;
                }
                console.log('Submitting...');
                var data = JSON.stringify($('form').serializeObject());
                console.log(data);
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    contentType: "application/json; charset=UTF-8",
                    url: '/registerUser', // php script to retern json encoded string
                    data: data,  // serialized data to send on server
                    dataType:'json', // set recieving type - JSON in case of a question
                    type:'POST', // set sending HTTP Request type
                    async:false,
                    success: function(response) { // callback method for further manipulations
                        console.log('form send success');
                        if(response.status == "SUCCESS"){
                            window.location = "/";
                        } else {
                            //var errorInfo = "";
                             for(i =0 ; i < response.result.length ; i++){
                                 var fName = response.result[i].field;
                                 console.log('Field name:'+fName);
                                 fName += "_error";
                                 console.log('Setting msg:'+response.result[i].defaultMessage);
                                 $('#'+fName).html("Error: "+response.result[i].defaultMessage);
                                 //errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                             }
                            $('#error_text').html("Please correct following errors:");
                        }
                    },
                    error: function(jqXHR, textStatus, errorThrown) { // if error occured
                        console.log(jqXHR.status + ' ' + jqXHR.responseText + ' ' + jqXHR.error);
                        console.log(textStatus);
                        console.log(errorThrown);
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
     <h3><div id="error_text" /></h3>
<div id="content">
    <table class="profiletable">
        <form action="/registerUser" method="post" class="form-horizontal" role="form" id="saveForm">
            <tr>
                <th>E-Mail (username):</th>
                <td>
                    <input type="text" id="username" name="username">
                </td>
                <td><div id="username_error" th:text="${username_error}" /></td>
            </tr>
            <tr>
                <th>Please enter password:</th>
                <td>
                    <input type="password" id="password" name="password">
                </td>
                <td><div id="password_error" th:text="${password_error}" /></td>
            </tr>
            <tr>
                <th>Please re-type password:</th>
                <td>
                    <input type="password" id="retypePassword" name="retypePassword">
                </td>
                <td><div id="retype_password_error" th:text="${password_error}" /></td>
            </tr>
            <tr>
                <th>First name:</th>
                <td>
                    <input type="text" id="first_name" name="firstName">
                </td>
                <td><div id="first_name_error" th:text="${first_name_error}" /></td>
            </tr>
            <tr>
                <th>Last name:</th>
                <td>
                    <input type="text" id="last_name" name="lastName">
                </td>
                <td><div id="last_name_error" th:text="${last_name_error}" /></td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" id="address" name="address">
                </td>
                <td><div id="address_error" th:text="${address_error}" /></td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                    <input type="text" id="city" name="city">
                </td>
                <td><div id="city_error" th:text="${city_error}" /></td>
            </tr>
            <tr>
                <th>Telephone No.:</th>
                <td>
                    <input type="text" id="telephone" name="telephone">
                </td>
                <td><div id="telephone_error" th:text="${telephone_error}" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="button" onclick="window.location.replace('/index')" value="Cancel" /></td>
                <td></td>
            </tr>
        </form>
    </table>

</div>

</body>
</html>