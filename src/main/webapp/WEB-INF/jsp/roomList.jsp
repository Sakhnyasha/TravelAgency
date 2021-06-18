<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hotel List</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>

    <spring:url value="/manager/hotels" var="hotelListUrl"/>
    <spring:url value="/hotels/${hotelId}/rooms/add" var="roomAddingUrl"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Room List</h4>
<div class="row">
    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${hotelListUrl}'">Hotels
            <i class="material-icons right">arrow_back</i>
        </button>
    </div>

    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="roomAdding" onclick="location.href='${roomAddingUrl}'">Add Room
            <i class="material-icons right">add</i>
        </button>
    </div>
</div>

<table style="table-layout: auto">
    <tr>
        <td><strong>Name</strong></td>
        <td><strong>Number of Persons</strong></td>
        <td><strong>Price</strong></td>

    </tr>
    <c:forEach items="${rooms}" var="room">
        <tr>
            <td>${room.name}</td>
            <td>${room.capacity}</td>
            <td>${room.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
