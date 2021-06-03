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

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Hotels List</h4>
<table style="table-layout: auto">
    <tr>
        <td><strong>Name</strong></td>
        <td><strong>Country</strong></td>
        <td><strong>City</strong></td>
        <td><strong>Address</strong></td>
        <td><strong>Edit</strong></td>
        <td><strong>Delete</strong></td>

    </tr>
    <c:forEach items="${hotels}" var="hotel">
        <tr>

            <td>${hotel.name}</td>
            <td>${hotel.country}</td>
            <td>${hotel.city}</td>
            <td>${hotel.address}</td>
            <td>
                <button class="btn waves-effect waves-light" type="edit" name="action">Edit
                    <i class="material-icons right">edit</i>
                </button>
            </td>
            <td>
                <button class="btn waves-effect waves-light" type="edit" name="action">Delete
                    <i class="material-icons right">delete</i>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
