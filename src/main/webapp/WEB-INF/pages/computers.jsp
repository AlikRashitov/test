<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Комплектующие</title>
</head>
<body>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2>Комплектующие</h2>
<table>
    <tr>
        <th>Наименование</th>
        <th>Количество</th>
        <th>Необходимость</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="computers" items="${computersList}">
        <tr>
            <td>${computers.name}</td>
            <td>${computers.countt}</td>
            <td>${computers.needed}</td>
            <td>
                <a href="/edit/${computers.id}">редактировать</a>
                <a href="/delete/${computers.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Можно собрать ${x} компьютеров</h2>

<h2>Добавить</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Добавить новую комплектующую</a>

<h2>Фильтр</h2>
<c:url value="/" var="url"/>
<a href="${url}">Все</a>
<a href="${true}">Необходимые</a>
<a href="${false}">Опциональные</a>


<h2>Поиск</h2>



<form method="get" action="find">
<input type="text" name="findname"/>
<input type="submit" value="Найти"/>

</form>
<c:forEach var="computers" items="${computersList}">

    <c:if test="${computers.name.toString() eq 'Процессор'}">
        <c:url value="/find/${computers.id}" var="varfind"/>
    </c:if>
</c:forEach>

</body>
</html>
