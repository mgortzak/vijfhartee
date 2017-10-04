<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head><title>Select your course</title></head>
<body>
<form action="courses" method="post">

    Select the desired course:
    <select name="id">

        <c:forEach var="course" items="${courseList}">

            <option value="${course.id}">${course.description}</option>

        </c:forEach>

    </select>

    <input type="submit" value="Details">

</form>
</body>

</html>