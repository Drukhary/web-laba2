<%--
  Created by IntelliJ IDEA.
  User: drukhary
  Date: 23.03.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="message">
    <h2>
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : ""%>
    </h2>
</div>
<table class="table">
    <thead>
    <tr>
        <th>Дата и время запроса</th>
        <th>Время выполнения</th>
        <th>Координата X</th>
        <th>Координата Y</th>
        <th>Параметр R</th>
        <th>Результат</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="table" class="drukhary.laba_2.AreaChecking.Table" scope="application"/>
    <c:forEach items="${table.data}" var="i">
        <tr>
            <td><c:out value="${i.data.toString()}"/></td>
            <td>
                <c:set var="prosessTime" value="${i.processTime}" scope="page"/>
                <%= java.math.BigDecimal.valueOf((Double) pageContext.findAttribute("prosessTime")).toPlainString() %>с
                <c:remove var="prosessTime" scope="page"/>
            </td>
            <td><c:out value="${i.point.x}"/></td>
            <td><c:out value="${i.point.y}"/></td>
            <td><c:out value="${i.radius}"/></td>
            <td>
                <c:if test="${i.result}">Точка входит в область</c:if>
                <c:if test="${!i.result}">Точка не входит в область</c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
