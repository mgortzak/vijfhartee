<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head><title>Category information</title></head>
<body>
ID: ${category.id}<br/>
Name: ${category.name}<br/>
Description: ${category.description}<br/>
Courses:
<ul>
    <c:forEach var="course" items="${category.courses}">
        <li>${course.description}</li>
    </c:forEach>
</ul>

</body>

</html>