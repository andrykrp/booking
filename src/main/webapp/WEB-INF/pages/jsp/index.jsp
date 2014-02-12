<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="/resources/style/style.css" rel="stylesheet">
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
        function initialize() {
            var myLatlng = new google.maps.LatLng(51.7691425,55.0947705);
            var mapOptions = {
                zoom: 15,
                center: myLatlng
            }
            var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            var marker = new google.maps.Marker({
                position: myLatlng,
                map: map,
                title: 'Orenburg'
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);

    </script>
</head>

<body>


<div class="wrapper">

    <div id="map-canvas" style="width: 1000px; height: 600px;"></div>

    <header class="header">
        <strong>Header:</strong>
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
            <strong>Right Sidebar:</strong> ${model["userList"]}
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