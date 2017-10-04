<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Add category</title></head>
<body>
<form action="add_category" method="post">
    <div>
        <label>Name:</label>
        <input name="name" type="text" value="Old"/>
    </div>
    <div>
        <label>Description:</label>
        <input name="description" type="text" value="Old stuff"/>
    </div>
    <input type="submit" value="Add">
</form>

</body>

</html>