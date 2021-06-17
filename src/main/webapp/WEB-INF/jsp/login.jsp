<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
<%--    to build in controller (only if post method)--%>
    <spring:url value="/login" var="loginURL"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Login</h4>
<div class="row">
    <form:form action="${loginURL}" method="post" class="col s12" enctype="application/x-www-form-urlencoded">

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">assignment_ind</i>
                <input placeholder="Email" id="login" type="email" class="validate" name="username">
                <label for="login">Login</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">security</i>
                <input placeholder="Password" id="password" type="password" class="validate" name="password">
                <label for="password">Password</label>
            </div>
        </div>


        <div class="row">
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="button"
                        name="action" onclick="location.href='register'">Registration
                    <i class="material-icons right">assignment_ind</i>
                </button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="input-field col s2">
                <button value="submit" class="btn waves-effect waves-light" type="submit" name="submit">Submit
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>
