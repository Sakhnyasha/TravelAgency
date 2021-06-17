<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add City</title>
    <spring:url value="/resources/css/materialize.min.css" var="minCss"/>
    <spring:url value="/resources/js/materialize.min.js" var="minJs"/>

    <link type="text/css" href="${minCss}" rel="stylesheet" media="screen,projection"/>
    <spring:url value="/manager/hotels" var="hotelListUrl"/>
    <spring:url value="/manager/cities/add" var="addCitySuccessUrl"/>

</head>
<div>
    <script type="text/javascript" src="${minJs}"></script>

    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems);
        });
    </script>

    <h4>Add City</h4>
    <div class="row">
        <form action="${addCitySuccessUrl}" method="post">
            <div class="row">
                <div class="input-field col s1">
                    <i class="material-icons prefix">language</i>
                    <label for="country" class="select-label">Country</label>
                </div>
                <div class="input-field col s5">
                    <select name="selectedCountry" id="country" required="required">
                        <option disabled selected> -- select country --</option>
                        <c:forEach items="${countries}" var="country">
                            <option value="${country.id}">${country.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s1">
                    <i class="material-icons prefix">location_city</i>
                    <label for="city">City</label>
                </div>
                <div class="input-field col s5">
                    <input id="city" type="text" class="validate" name="city">
                </div>
            </div>

            <div class="row">
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light" type="button"
                            name="action" onclick="location.href='${hotelListUrl}'">Cancel
                        <i class="material-icons right">cancel</i>
                    </button>
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
