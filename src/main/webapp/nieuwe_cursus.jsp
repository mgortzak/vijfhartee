<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Toevoegen cursus</title></head>
<body>
<form action="nieuwe_cursus" method="post">
    <div>
        <label>Naam:</label>
        <input name="naam" type="text" value="Fortran"/>
    </div>
    <div>
        <label>Omschrijving:</label>
        <input name="omschrijving" type="text" value="Fortran voor gevorderden"/>
    </div>
    <div>
        <label>Duur:</label>
        <input name="duur" type="text" value="2"/>
    </div>
    <div>
        <label>Prijs:</label>
        <input name="prijs" type="text" value="550"/>
    </div>
    <input type="submit" value="Toevoegen">
</form>

</body>

</html>