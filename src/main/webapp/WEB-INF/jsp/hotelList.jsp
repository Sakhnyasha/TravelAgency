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

    <spring:url value="/manager/hotels/add" var="addHotelsUrl"/>
    <spring:url value="/manager/hotels/delete" var="deleteHotelURL"/>
    <spring:url value="/user/cabinet" var="toUserCabinetlURL"/>
    <spring:url value="/manager/cities" var="manageCitiesUrl"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Hotels</h4>
<div class="row">
    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${toUserCabinetlURL}'">User Cabinet
            <i class="material-icons right">arrow_back</i>
        </button>
    </div>

    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${addHotelsUrl}'">Add Hotel
            <i class="material-icons right">add</i>
        </button>
    </div>
    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${manageCitiesUrl}'">Add Cities
            <i class="material-icons right">location_city</i>
        </button>
    </div>
</div>
<div class="row" align="center">
    <table style="table-layout: auto">
        <tr>
            <td><strong>Name</strong></td>
            <td><strong>Country</strong></td>
            <td><strong>City</strong></td>
            <td><strong>Address</strong></td>
            <td><strong></strong></td>
            <td><strong></strong></td>

        </tr>
        <c:forEach items="${hotels}" var="hotel">
            <tr>

                <td>${hotel.name}</td>
                <td>${hotel.country}</td>
                <td>${hotel.city}</td>
                <td>${hotel.address}</td>
                <td>
                    <form:form name="deleteForm" id="deleteForm" method="post" action="${deleteHotelURL}">
                        <button value="${hotel.id}" class="btn waves-effect waves-light" type="submit"
                                name="hotelToDelete">Delete
                            <i class="material-icons right">delete</i>
                        </button>
                    </form:form>
                </td>
                <td>
                    <button class="btn waves-effect waves-light" type="button" name="action"
                            onclick="location.href='<spring:url value="/hotels/${hotel.id}/rooms"/>'">Edit Rooms
                        <i class="material-icons right">edit</i>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
