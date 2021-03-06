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
    <spring:url value="/manager/hotels" var="manageHotelsUrl"/>
    <spring:url value="/manager/hotels/add" var="addHotelUrl"/>
    <spring:url value="/manager/hotels/add/success" var="addHotelSuccessUrl"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems);
    });
</script>

<h4>Add Hotel</h4>
<div class="row">
    <div class="row">
        <div class="input-field col s1">
            <i class="material-icons prefix">language</i>
            <label for="country" class="select-label">Country</label>
        </div>
        <div class="input-field col s5">
            <form action="${addHotelUrl}" method="post">
                <select name="selectedCountry" id="country" required onchange="this.form.submit()">
                    <c:if test="${empty selectedCountry}">
                        <option disabled selected value=""> -- select country --</option>
                    </c:if>
                    <c:if test="${not empty selectedCountry}">
                        <option disabled> -- select country --</option>
                    </c:if>
                    <c:forEach items="${countries}" var="country">
                        <c:if test="${country.id eq selectedCountry}">
                            <option value="${country.id}" selected>${country.name}</option>
                        </c:if>
                        <c:if test="${selectedCountry ne country.id}">
                            <option value="${country.id}">${country.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </form>
        </div>
    </div>

    <form:form id="hotelData" action="${addHotelSuccessUrl}" method="post" modelAttribute="newHotel">
        <div class="row">
            <div class="input-field col s1">
                <i class="material-icons prefix">location_city</i>
                <label for="city">City</label>
            </div>
            <div class="input-field col s5">
                <select name="cityId" id="city" class="select-dropdown" required>
                    <c:if test="${empty selectedCity}">
                        <option disabled selected value=""> -- select city --</option>
                    </c:if>
                    <c:if test="${not empty selectedCity}">
                        <option disabled> -- select city --</option>
                    </c:if>
                    <c:forEach items="${cities}" var="city">
                        <c:if test="${city.id eq selectedCity}">
                            <option value="${city.id}" selected>${city.name}</option>
                        </c:if>
                        <c:if test="${selectedCity ne city.id}">
                            <option value="${city.id}">${city.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <form:errors path="cityId" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">hotel</i>
                <input id="name" type="text" class="validate" name="hotelName" form="hotelData"
                       required value="${hotelName}">
                <label for="name">Hotel Name</label>
                <form:errors path="hotelName" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">my_location</i>
                <input id="address" type="text" class="validate" name="hotelAddress"
                       required value="${address}">
                <label for="address">Address</label>
                <form:errors path="hotelAddress" cssClass="error"/>
            </div>
        </div>
    </form:form>


    <div class="row">
        <div class="input-field col s2">
            <button class="btn waves-effect waves-light" type="button"
                    name="action" onclick="location.href='${manageHotelsUrl}'">Cancel
                <i class="material-icons right">cancel</i>
            </button>
        </div>
        <div class="input-field col s2">
            <button class="btn waves-effect waves-light" type="submit" name="action" form="hotelData">Submit
                <i class="material-icons right">send</i>
            </button>
        </div>
    </div>
</div>
</body>
</html>
