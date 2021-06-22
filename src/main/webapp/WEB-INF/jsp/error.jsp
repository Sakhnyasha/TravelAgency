<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Error</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <spring:url value="/user/cabinet" var="toUserCabinetlURL"/>
    <spring:url value="/resources/img/oops.jpg" var="image"/>

    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<div class="row">
    <div class="input-field col s3">
        <button class="btn waves-effect waves-light" type="button"
                name="action" onclick="location.href='${toUserCabinetlURL}'">To User Cabinet
            <i class="material-icons right">arrow_back</i>
        </button>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <h5>Something went wrong: ${message}</h5>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <img src="${image}" alt="Ой, всьо..." width="640" height="360">
    </div>
</div>

</body>
</html>
