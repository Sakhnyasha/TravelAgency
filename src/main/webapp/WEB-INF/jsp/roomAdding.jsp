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

    <spring:url value="/hotels/${hotelId}/rooms/add" var="roomAddingURL"/>
    <spring:url value="/hotels/${hotelId}/rooms" var="roomListURL"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Room Adding</h4>
<div class="row">
    <form action="${roomAddingURL}" method="post">
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">room_service</i>
                <input placeholder="Enter name(type)" id="name" type="text" class="validate" name="name">
                <label for="name">Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">attach_money</i>
                <input placeholder="Enter price" id="price" type="text" class="validate" name="price">
                <label for="price">Price</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">person_add</i>
                <input placeholder="Enter capacity of room" id="capacity" type="text" class="validate" name="capacity">
                <label for="capacity">Capacity</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="button"
                        name="action" onclick="location.href='${roomListURL}'">Cancel
                    <i class="material-icons right">cancel</i>
                </button>
            </div>
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
