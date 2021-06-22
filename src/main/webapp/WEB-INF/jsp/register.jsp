<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ann
  Date: 01.06.2021
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <spring:url value="/register" var="registerURL"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Registration</h4>
<div class="row">
    <form:form action="${registerURL}" method="post" class="col s12" modelAttribute="user">

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">assignment_ind</i>
                <input placeholder="Enter your email" id="email" type="email" class="validate" name="email" required>
                <label for="email">Email</label>
                <form:errors path="email" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">security</i>
                <input placeholder="Enter your password" id="password" type="password" class="validate" name="password" required>
                <label for="password">Password</label>
                <form:errors path="password" cssClass="error"/>
            </div>

            <div class="input-field col s6">
                <i class="material-icons prefix">verified_user</i>
                <input placeholder="Enter your password again" id="passwordConfirmation" type="password"
                       class="validate" name="passwordConfirmation" required>
                <label for="password">Password Confirmation</label>
                <form:errors path="passwordConfirmation" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input placeholder="Enter your name" id="first_name" type="text" class="validate" name="firstName" required>
                <label for="first_name">First Name</label>
                <form:errors path="firstName" cssClass="error"/>
            </div>

            <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input placeholder="Enter your surname" id="last_name" type="text" class="validate" name="lastName" required>
                <label for="last_name">Last Name</label>
                <form:errors path="lastName" cssClass="error"/>
            </div>
        </div>



        <div class="row">
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="button"
                        name="action" onclick="location.href='login'" >Cancel
                    <i class="material-icons right">cancel</i>
                </button>
            </div>
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>
