<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head><title>Course information</title></head>
<body>
ID: ${course.id}<br/>
Name: ${course.name}<br/>
Description: ${course.description}<br/>
Duration: ${course.duration}<br/>
Price: ${course.price} euro<br/>
Categories:
<ul>
    <c:forEach var="category" items="${course.categories}">
        <li>${category.description}</li>
    </c:forEach>
</ul>

</body>

</html>