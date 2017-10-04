<%@ page import="java.time.LocalDateTime" %>
<html>

<head><title>Aanmelding gelukt!</title></head>
<body>
<p>
    Beste ${aanmelding.voornaam} ${aanmelding.achternaam},
</p>

<p>
    De aanmelding voor de cursus is op <%= LocalDateTime.now()%> gelukt.
</p>

<p>
    Deze informatie wordt ook per e-mail aan u gestuurd.
</p>

<p>
    Met vriendelijke groet,<br/>
    Het secretariaat
</p>

</body>

</html>