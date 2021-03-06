<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User List</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>


    <spring:url value="/manager/hotels" var="manageHotelsUrl"/>
    <spring:url value="/manager/userList" var="userListUrl"/>
    <spring:url value="/logout" var="logout"/>


</head>
<body>
<script type="text/javascript" src="${minJs}"></script>
<div class="row">
    <h4>User Cabinet</h4>
</div>

<div class="row">
    <div class="col s3">
        <h6>Hello
            <security:authorize access="isAuthenticated()">
                <security:authentication property="principal.firstName"/>

                <security:authentication property="principal.lastName"/>
            </security:authorize>
            !</h6>
    </div>
</div>

<div class="row">
    <div class="col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='booking'">To Booking
            <i class="material-icons right">arrow_back</i>
        </button>
    </div>

    <security:authorize access="hasRole('ROLE_MANAGER')">
        <div class="col s3">
            <button class="btn waves-effect waves-light" type="button"
                    name="action" onclick="location.href='${manageHotelsUrl}'">Manage Hotels
                <i class="material-icons right">hotel</i>
            </button>
        </div>

        <div class="col s3">
            <button class="btn waves-effect waves-light" type="button"
                    name="action" onclick="location.href='${userListUrl}'">User List
                <i class="material-icons right">supervisor_account</i>
            </button>
        </div>
    </security:authorize>

    <div class="col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${logout}'">Log out
            <i class="material-icons right">person_outline</i>
        </button>
    </div>


</div>

<div class="row">
    <div class="col s12">

        <table style="table-layout: auto">
            <tr>
                <td><strong>Number of booking</strong></td>
                <td><strong>Hotel Name</strong></td>
                <td><strong>Location</strong></td>
                <td><strong>Check-in Date</strong></td>
                <td><strong>Check-out Date</strong></td>
                <td><strong>Room Name</strong></td>
                <td><strong>Number of Persons</strong></td>
                <td><strong>Price</strong></td>
            </tr>
            <c:forEach items="${bookings}" var="booking">
                <tr>
                    <td>${booking.id}</td>
                    <td>${booking.room.hotel.name}</td>
                    <td>${booking.room.hotel.city.country.name}, ${booking.room.hotel.city.name}, ${booking.room.hotel.address} </td>
                    <td>${booking.checkIn}</td>
                    <td>${booking.checkOut}</td>
                    <td>${booking.room.name}</td>
                    <td>${booking.room.capacity}</td>
                    <td>${booking.room.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
