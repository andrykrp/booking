<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="hotel" items="${hotels}">
        <p>Id: <b>${hotel.hotelId}</b> Name: <b>${hotel.name}</b> - Short description: <c:out value="${hotel.shortDescription}" escapeXml="false"/> </p>
    </c:forEach>
</body>
</html>