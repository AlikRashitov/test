<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>Поиск</title>

</head>
<body>

<table>
    <tr>
        <th>Наименование</th>
        <th>Количество</th>
        <th>Необходимость</th>

    </tr>
    <c:forEach var="computers" items="${computersList}">
        <tr>
            <td>${computers.name}</td>
            <td>${computers.countt}</td>
            <td>${computers.needed}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
