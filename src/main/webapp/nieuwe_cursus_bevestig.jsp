<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Toevoegen cursus</title></head>
<body>
<form action="nieuwe_cursus_bevestig" method="post">
    <div>
        <label>Naam:</label>
        <input name="naam" type="text" value="${cursus.naam}"/>
    </div>
    <div>
        <label>Omschrijving:</label>
        <input name="omschrijving" type="text" value="${cursus.omschrijving}"/>
    </div>
    <div>
        <label>Duur:</label>
        <input name="duur" type="text" value="${cursus.duur}"/>
    </div>
    <div>
        <label>Prijs:</label>
        <input name="prijs" type="text" value="${cursus.prijs}"/>
    </div>
    <input type="submit" value="Bevestigen">
</form>

</body>

</html>