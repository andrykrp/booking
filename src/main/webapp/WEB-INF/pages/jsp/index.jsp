<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="/resources/style/style.css" rel="stylesheet">
</head>

<body>
<security.authentication property="principal" var="loginData" scope="page" />

<div class="wrapper">

    <header class="header">
        <sec:authorize var="loggedIn" access="isAuthenticated()"/>
        <c:choose>
            <c:when test="${loggedIn}">
                <p><strong>You are currently logged in as <b>${user.firstName} ${user.lastName}</b>.
                    <a href="/j_spring_security_logout"><b>Logout</b></a></strong>
                <br>To edit your personal data please proceed to <a href="/userProfile">your profile page</a>.
            </c:when>
            <c:otherwise>
                <p><strong>You are currently not logged in.
                    If you are registered with us, please <a href="/j_spring_security_login">Login</a></strong>
                <br>To register please proceed to <a href="/registerUser">Registration form</a>.</p>
            </c:otherwise>
        </c:choose>
    </header>

    <div class="find-middle">

        <div class="container">
            <main class="find-content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,
                aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.
                Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,
                nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum.
                Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada
                lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit. Nam nisl tellus, placerat eget,
                posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada
                fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit. Nam nisl tellus,
                placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus
                et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
            </main>
        </div>

        <aside class="find-right-sidebar">
            <strong>Right Sidebar. User from model: ${model["userList"]}, user from session: ${user.username}</strong>
        </aside>

    </div>

    <div class="middle">

        <div class="container">
            <main class="content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,
                aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.
                Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,
                nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum.
                Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada
                lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.
            </main>
        </div>

        <aside class="left-sidebar">
            <strong>Left Sidebar:</strong> Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a,
            mi. Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique
            senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas
            vel elit. Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a, mi. Nam nisl tellus,
            placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et
            malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
        </aside>

    </div>
</div>

<footer class="footer">
    <div class="footer-middle">

        <div class="container">
            <main class="footer-content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,
                aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.
                Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,
                nibh.
            </main>
        </div>

    </div>
    <strong>Footer:</strong> Mus elit Morbi mus enim lacus at quis Nam eget morbi. Et semper urna urna non at cursus
    dolor vestibulum neque enim. Tellus interdum at laoreet laoreet lacinia lacinia sed Quisque justo quis. Hendrerit
    scelerisque lorem elit orci tempor tincidunt enim Phasellus dignissim tincidunt. Nunc vel et Sed nisl Vestibulum
    odio montes Aliquam volutpat pellentesque. Ut pede sagittis et quis nunc gravida porttitor ligula.
</footer>

</body>
</html>