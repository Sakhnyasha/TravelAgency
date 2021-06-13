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
    <spring:url value="/login" var="loginURL"/>

</head>
<body>
<script type="text/javascript" src="${minJs}"></script>

<div class="row">
    <div class="row">

        <div class="header">
            <h4>Room Booking</h4>
        </div>

        <div class="col s6">
            <form method="post" action="/booking" id="booking">
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
                </div>

                <div class="row">
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
                                name="action" onclick="location.href='${loginURL}'">Cancel
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

            <div class="input-field col s3">
                <button class="btn waves-effect waves-light" type="submit"
                        name="action">Book
                    <i class="material-icons right">check</i>
                </button>
            </div>
        </div>

    </div>
</div>

</body>
</html>
