<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Booking</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>
    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>
    <spring:url value="/user/cabinet" var="toUserCabinetlURL"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>
<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems);
    });
</script>

<div class="row">
    <div class="row">

        <div class="header">
            <h4>Room Booking</h4>
        </div>

        <div class="col s6">

                <div class="row">
                    <div class="input-field col s2">
                        <i class="material-icons prefix">language</i>
                        <label for="country" class="select-label">Country</label>
                    </div>
                    <div class="input-field col s4">
                        <form action="${addHotelUrl}" method="post">
                            <select name="selectedCountry" id="country" required="required" onchange="this.form.submit()">
                                <c:if test="${empty selectedCountry}">
                                    <option disabled selected> -- select country --</option>
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
            <form method="post" action="/booking" id="booking">
                <div class="row">
                    <div class="input-field col s2">
                        <i class="material-icons prefix">location_city</i>
                        <label for="city">City</label>
                    </div>
                    <div class="input-field col s4">
                        <select name="cityId" id="city" class="select-dropdown" required="required">
                            <option disabled="disabled" selected="selected"> -- select city --</option>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.id}">${city.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">arrow_downward</i>
                        <label for="checkin" class="select-label">Check-in Date</label>
                        <input type="date" id="checkin" name="checkin" value=""
                               max="2023-06-01" min="2021-06-01" class="datepicker-calendar-container"
                               required="" placeholder="mm/dd/yyyy">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">arrow_upward</i>
                        <label for="checkout" class="select-label">Check-out Date</label>
                        <input type="date" id="checkout" name="checkout" value=""
                               max="2023-06-01" min="2021-06-01" class="datepicker-calendar-container"
                               required="" placeholder="mm/dd/yyyy">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person_add</i>
                        <label for="adults" class="select-label">Number of Persons</label>
                        <input type="number" id="adults" name="adults" required="" max="10" min="1"
                               placeholder="Number of Persons">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s3">
                        <button class="btn waves-effect waves-light" type="button"
                                name="action" onclick="location.href='${toUserCabinetlURL}'">Cancel
                            <i class="material-icons right">cancel</i>
                        </button>
                    </div>
                    <div class="input-field col s3">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Search
                            <i class="material-icons right">search</i>
                        </button>
                    </div>
                </div>

            </form>
        </div>

        <div class="col s6" align="center">
            <div class="row">
                <h5>Available Hotels</h5>
            </div>

            <div class="row">
                <div class="input-field col s3">
                    <button class="btn waves-effect waves-light" type="submit"
                            name="action">Book
                        <i class="material-icons right">check</i>
                    </button>
                </div>
            </div>
            <div class="row" align="center">
                <table style="table-layout: auto">
                    <tr>
                        <td><strong>Name</strong></td>
                        <td><strong>Address</strong></td>
                        <td><strong>Price</strong></td>
                        <td><strong>Check</strong></td>

                    </tr>
                    <c:forEach items="${hotels}" var="hotel">
                        <tr>
                            <td>${hotel.name}</td>
                            <td>${hotel.address}</td>
                            <td>${room.price}</td>
                            <td>
                                <button class="btn waves-effect waves-light" type="submit" name="check">
                                    <i class="material-icons right">check_circle</i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
