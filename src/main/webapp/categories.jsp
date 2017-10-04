<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head><title>Select your category</title></head>
<body>
<form action="categories" method="post">

    Select the desired category:
    <select name="id">

        <c:forEach var="category" items="${categoryList}">

            <option value="${category.id}">${category.description}</option>

        </c:forEach>

    </select>

    <input type="submit" value="Details">

</form>
</body>

</html>