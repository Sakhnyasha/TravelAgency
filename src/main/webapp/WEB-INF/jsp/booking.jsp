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
    <spring:url value="/user/booking" var="toUserBookinglURL"/>
    <spring:url value="/user/booking/search" var="toUserBookingSearchlURL"/>
    <spring:url value="/user/booking/submit" var="toUserBookingSubmitlURL"/>

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
                    <form:form action="${toUserBookinglURL}" method="post" modelAttribute="booking">
                        <select name="selectedCountryId" id="country" required onchange="this.form.submit()">
                            <c:if test="${empty selectedCountryId}">
                                <option disabled selected value=""> -- select country --</option>
                            </c:if>
                            <c:if test="${not empty selectedCountryId}">
                                <option disabled value=""> -- select country --</option>
                            </c:if>
                            <c:forEach items="${countries}" var="country">
                                <c:if test="${country.id eq selectedCountryId}">
                                    <option value="${country.id}" selected>${country.name}</option>
                                </c:if>
                                <c:if test="${selectedCountryId ne country.id}">
                                    <option value="${country.id}">${country.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <form:errors path="selectedCountryId" cssClass="error"/>
                    </form:form>
                </div>
            </div>
            <form:form method="post" action="${toUserBookingSearchlURL}" id="booking" modelAttribute="booking">
                <input type="hidden" name="selectedCountryId" value="${selectedCountryId}"/>
                <div class="row">
                    <div class="input-field col s2">
                        <i class="material-icons prefix">location_city</i>
                        <label for="city">City</label>
                    </div>
                    <div class="input-field col s4">
                        <select name="selectedCityId" id="city" class="select-dropdown" required>
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
                        <form:errors path="selectedCityId" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">arrow_downward</i>
                        <label for="checkin" class="select-label">Check-in Date</label>
                        <input type="date" id="checkin" name="checkIn"
                               max="2023-06-01" min="2021-06-01" class="datepicker-calendar-container"
                               required placeholder="mm/dd/yyyy" value="${booking.checkIn}">
                        <form:errors path="checkIn" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">arrow_upward</i>
                        <label for="checkout" class="select-label">Check-out Date</label>
                        <input type="date" id="checkout" name="checkOut"
                               max="2023-06-01" min="2021-06-01" class="datepicker-calendar-container"
                               required placeholder="mm/dd/yyyy" value="${booking.checkOut}">
                        <form:errors path="checkOut" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person_add</i>
                        <label for="capacity" class="select-label">Number of Persons</label>
                        <input type="number" id="capacity" name="capacity" required max="10" min="1"
                               placeholder="Number of Persons" value="${booking.capacity}">
                        <form:errors path="capacity" cssClass="error"/>
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

            </form:form>
        </div>

        <div class="col s6" align="center">
            <div class="row">
                <h5>Available Hotels</h5>
            </div>

            <div class="row" align="center">
                <table style="table-layout: auto">
                    <tr>
                        <td><strong>Hotel Name</strong></td>
                        <td><strong>Room Name</strong></td>
                        <td><strong>Room Price</strong></td>
                        <td></td>

                    </tr>
                    <c:forEach items="${booking.availableRooms}" var="room">
                        <form:form modelAttribute="booking" method="post" action="${toUserBookingSubmitlURL}">
                            <tr>
                                <td>${room.hotel.name}</td>
                                <td>${room.name}</td>
                                <td>${room.price}</td>
                                <td>
                                    <button class="btn waves-effect waves-light" type="submit"
                                            name="selectedRoom" value="${room.id}">Book
                                        <i class="material-icons right">check</i>
                                    </button>
                                    <input type="hidden" name="checkIn" value="${booking.checkIn}"/>
                                    <input type="hidden" name="checkOut" value="${booking.checkOut}"/>
                                </td>
                            </tr>
                        </form:form>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
