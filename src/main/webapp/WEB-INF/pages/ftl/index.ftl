<#assign security=JspTaglibs["/WEB-INF/security.tld"] />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title>Hotel Booking</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="/resources/style/style.css" rel="stylesheet">
</head>

<body>
<@security.authentication property="principal" var="loginData" scope="page" />

<div class="wrapper">

    <header class="header">
        <#if .globals.loginData?is_hash_ex && .globals.loginData.username??>
        <p><strong>You are currently logged in as <b><em>${.globals.loginData.username}</em></b>.
                <a href="/j_spring_security_logout"><b>Logout</b></a></strong>
            <br>To edit your personal data please proceed to <a href="/userProfile">your profile page</a>.</p>
        <#elseif .globals.loginData?is_string && .globals.loginData == "anonymousUser">
            <p>You are not logged in. Please proceed to <a href="/spring_security_login"><b>Login page</b></a></p>
        </#if>
        <strong>Header:</strong> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tortor. Praesent dictum, libero ut tempus dictum, neque eros elementum mauris, quis mollis arcu velit ac diam. Etiam neque. Quisque nec turpis. Aliquam arcu nulla, dictum et, lacinia a, mollis in, ante. Sed eu felis in elit tempor venenatis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
    </header>

    <div class="find-middle">

        <div class="container">
            <main class="find-content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu, aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede. Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non, nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum. Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.  Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.  Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
            </main>
        </div>

        <aside class="find-right-sidebar">
            <strong>Right Sidebar:</strong> ${model["userList"]}
        </aside>

    </div>

    <div class="middle">

        <div class="container">
            <main class="content">
                <strong>Content:</strong>
                <table class="datatable">
                    <tr>
                        <th>Firstname</th>  <th>Lastname</th>  <th>Address</th>  <th>City</th>  <th>Phone No.</th>
                    </tr>
                    <tr>
                    <#if model["userList"]??>
                    <#list model["userList"] as user>
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
            </main>
        </div>

        <aside class="left-sidebar">
            <strong>Left Sidebar:</strong> Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a, mi. Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit. Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a, mi. Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
        </aside>

    </div>
</div>

<footer class="footer">
    <div class="footer-middle">

        <div class="container">
            <main class="footer-content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu, aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede. Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non, nibh.
            </main>
        </div>

    </div>
    <strong>Footer:</strong> Mus elit Morbi mus enim lacus at quis Nam eget morbi. Et semper urna urna non at cursus dolor vestibulum neque enim. Tellus interdum at laoreet laoreet lacinia lacinia sed Quisque justo quis. Hendrerit scelerisque lorem elit orci tempor tincidunt enim Phasellus dignissim tincidunt. Nunc vel et Sed nisl Vestibulum odio montes Aliquam volutpat pellentesque. Ut pede sagittis et quis nunc gravida porttitor ligula.
</footer>

</body>
</html>
