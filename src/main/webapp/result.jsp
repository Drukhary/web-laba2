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
            <td>${i.formatDate}</td>
            <td>${i.formatProcessTime}</td>
            <td>${i.point.x}</td>
            <td>${i.point.y}</td>
            <td>${i.radius}</td>
            <td>${i.formatResult}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
