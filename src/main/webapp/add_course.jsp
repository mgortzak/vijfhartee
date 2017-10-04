<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Add course</title></head>
<body>
<form action="add_course" method="post">
    <div>
        <label>Name:</label>
        <input name="name" type="text" value="Fortran"/>
    </div>
    <div>
        <label>Description:</label>
        <input name="description" type="text" value="Fortran voor gevorderden"/>
    </div>
    <div>
        <label>Duration:</label>
        <input name="duration" type="text" value="2"/>
    </div>
    <div>
        <label>Price:</label>
        <input name="price" type="text" value="550"/>
    </div>
    <input type="submit" value="Add">
</form>

</body>

</html>