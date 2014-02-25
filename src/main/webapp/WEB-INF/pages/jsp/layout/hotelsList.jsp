<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="hotel" items="${hotels}">
        <p>Name: <b>${hotel.name}</b></p>
        <p>Address: <b>${hotel.address}, ${hotel.city}, ${hotel.postalCode}, ${hotel.countryCode}</b></p>
        <p>Short description: <c:out value="${hotel.locationDescription}" escapeXml="false"/> </p>
        <p><img src="${hotel.thumbNailUrl}"></p>
    </c:forEach>
</body>
</html>