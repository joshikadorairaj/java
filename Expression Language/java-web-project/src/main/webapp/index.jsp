<!DOCTYPE html>
<html>
<head>
    <title>HTTP Request Headers</title>
</head>
<body>
    <h1>HTTP Request Headers</h1>

    <p>User-Agent Header: ${header['User-Agent']}</p>
    <p>Accept-Language Header: ${header['Accept-Language']}</p>

    <h2>All Accept Headers:</h2>
    <ul>
        <c:forEach var="accept" items="${headerValues['Accept']}">
            <li>${accept}</li>
        </c:forEach>
    </ul>
</body>
</html> 
