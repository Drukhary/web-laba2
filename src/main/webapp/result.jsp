<%--
  Created by IntelliJ IDEA.
  User: drukhary
  Date: 23.03.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%@ page import="com.drukhary.laba_2.AreaChecking.ElementInfo" %>
    <%@ page import="java.util.ArrayList" %>
    <%
        for (ElementInfo i :
                (ArrayList<ElementInfo>) config.getServletContext().getAttribute("table")) {
            out.println("<tr>");
            out.println("<td>" + i.getData() + "</td>");
            out.println("<td>" + i.getProcessTime() + "</td>");
            out.println("<td>" + i.getPoint().getX() + "</td>");
            out.println("<td>" + i.getPoint().getY() + "</td>");
            out.println("<td>" + i.getRadius() + "</td>");
            out.println("<td>" + (i.isResult() ? "Точка входит в область" : "Точка не входит в область") + "</td>");
            out.println("</tr>");
        }
    %>
    </tbody>
</table>
