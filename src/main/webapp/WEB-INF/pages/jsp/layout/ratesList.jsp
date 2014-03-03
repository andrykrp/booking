<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rates list</title>
</head>
<body>
<h2>Rates for the chosen hotel are:</h2>
    <c:forEach var="room" items="${rooms}">
        <p>Room type: <b>${room.roomTypeName}</b></p>
        <p>Description: <c:out value="${room.roomTypeDescription}" escapeXml="false"/> </p>
        <p>Minimum stay: <b>${room.minNights} nights</b></p>
    </c:forEach>
</body>
</html>