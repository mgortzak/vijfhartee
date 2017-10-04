<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head><title>Selecteer uw cursus</title></head>
<body>
<form action="cursussen" method="post">

    Selecteer de gewenste cursus:
    <select id="selectedCourse" name="selectedCourse">

        <c:forEach var="course" items="${courseList}">

            <option value="${course.id}">${course.omschrijving}</option>

        </c:forEach>

    </select>

    <input type="submit" value="Details">

</form>
</body>

</html>