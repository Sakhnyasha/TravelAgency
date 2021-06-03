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

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Users List</h4>
<table style="table-layout: auto">
  <tr>
    <td><strong>Login</strong></td>
    <td><strong>Firs Name</strong></td>
    <td><strong>Last Name</strong></td>
  </tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.login}</td>
      <td>${user.first_name}</td>
      <td>${user.last_name}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
