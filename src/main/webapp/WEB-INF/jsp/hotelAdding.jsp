<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Hotel</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<h4>Add Hotel</h4>
<div class="row">
    <form:form action="/hotel" method="post" class="col s12" modelAttribute="hotel">

        <div class="row">
            <div>
                <h6>Hotel Name</h6>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">hotel</i>
                <input id="name" type="text" class="validate" name="name">
                <label for="name">Hotel Name</label>
            </div>
        </div>

        <div class="row">
            <div>
                <h6>Hotel Location</h6>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">language</i>
                <label for="country" class="select-label">Country</label>
                <select name="country" id="country" class="select-dropdown" onselect="">
                    <c:forEach items="${countries}" var="country">
                        <option value="${country.id}">${country.name}
                        </option>
                    </c:forEach>
                </select>

            </div>

            <div class="input-field col s6">
                <i class="material-icons prefix">location_city</i>
                <label for="city">City</label>
                <select name="city" id="city" class="select-dropdown">
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.id}">${city.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-field col s6">
                <i class="material-icons prefix">my_location</i>
                <input id="address" type="text" class="validate" name="address">
                <label for="address">Address</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s2">
                <button class="btn waves-effect waves-light" type="button"
                        name="action" onclick="location.href='hotelList'">Cancel
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
