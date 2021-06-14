<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User List</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>
    <spring:url value="/manager/userList" var="userListURL"/>
    <spring:url value="/manager/userList/deleteUser" var="deleteUserURL"/>
    <spring:url value="/manager/userList/changeRoleUser" var="changeRoleUserURL"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Users List</h4>

<table style="table-layout: auto">
    <tr>
        <td><strong>Login</strong></td>
        <td><strong>Firs Name</strong></td>
        <td><strong>Last Name</strong></td>
        <td><strong>Role</strong></td>
        <td></td>
        <td></td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>

            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.role}</td>
            <td>
                <form:form name="deleteForm" id="deleteForm" method="post" action="${deleteUserURL}">
                    <button value="${user.id}" class="btn waves-effect waves-light" type="submit" name="userToDelete">
                        Delete
                        <i class="material-icons right">delete</i>
                    </button>
                </form:form>
            </td>
            <td>
                <form:form name="promoteForm" id="promoteForm" method="post" action="${changeRoleUserURL}">
                    <button value="${user.id}" class="btn waves-effect waves-light" type="submit"
                            name="userToChangeRole">
                        <c:if test="${user.role == 'MANAGER'}">
                            Demote to USER
                            <i class="material-icons right">arrow_downward</i>
                        </c:if>
                        <c:if test="${user.role == 'USER'}">
                            Promote to MANAGER
                            <i class="material-icons right">arrow_upward</i>
                        </c:if>
                    </button>
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
