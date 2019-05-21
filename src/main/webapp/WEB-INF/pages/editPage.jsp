<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty computer.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty computer.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty computer.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty computer.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty computer.name}">
        <input type="hidden" name="id" value="${computer.id}">
    </c:if>
    <label for="name">Наименование</label>
    <input type="text" name="name" id="name">
    <label for="countt">Количество</label>
    <input type="text" name="countt" id="countt">
    <label for="needed">Необходимость</label>
    <input type="text" name="needed" id="needed">
    <c:if test="${empty computer.name}">
        <input type="submit" value="Добавить новую комплектующую">
    </c:if>
    <c:if test="${!empty computer.name}">
        <input type="submit" value="Редактировать комплектующую">
    </c:if>
</form>
</body>
</html>
