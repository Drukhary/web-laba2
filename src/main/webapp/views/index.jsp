<%--
  Created by IntelliJ IDEA.
  User: drukhary
  Date: 19.03.2021
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Лабораторная работа №2 //Крисанов Роман</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        <%@include file="../resources/css/style.css"%>
        <%@include file="../resources/css/table.css"%>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>
<div class="header"><!--Создаём шапку страницы-->
    <h3>Крисанов Роман Валерьевич</h3>
    <p>
        <b>группа:</b> P3212
        <b>вариант:</b> 2316
    </p>
    <hr> <!--горизонтальная линия-->
</div>
<div class="form">
    <form method="GET">
        <div class="elem">
            <p><input id="resetForm" type="reset"></p>
        </div>
        <div class="elem">
            Параметр R:
            <p>
                <button type="button" class="setR" name="R" value=1>1</button>
                <button type="button" class="setR" name="R" value=2>2</button>
                <button type="button" class="setR" name="R" value=3>3</button>
                <button type="button" class="setR" name="R" value=4>4</button>
                <button type="button" class="setR" name="R" value=5>5</button>
            </p>
        </div>
        <div class="elem" id="image_R">
            <p class="electR">R = </p>
            <p class="electR" id="selectedR">
        </div>
        <div class="elem">
            Координата X:
            <p>
                <button type="button" class="setX" name="X" value=-3>-3</button>
                <button type="button" class="setX" name="X" value=-2>-2</button>
                <button type="button" class="setX" name="X" value=-1>-1</button>
                <button type="button" class="setX" name="X" value=0>0</button>
                <button type="button" class="setX" name="X" value=1>1</button>
                <button type="button" class="setX" name="X" value=2>2</button>
                <button type="button" class="setX" name="X" value=3>3</button>
                <button type="button" class="setX" name="X" value=4>4</button>
                <button type="button" class="setX" name="X" value=5>5</button>
            </p>
        </div>
        <div class="elem" id="image_X">
            <p class="electX">X = </p>
            <p class="electX" id="selectedX">
        </div>
        <div class="elem">
            Координата Y:
            <label>
                <input type="text" id="coordinateY" class="coordinateY" name="Y" placeholder="введите число от -5 до 3"
                       required>
            </label>
        </div>
        <div class="elem">
            <input type="button" class="submit" onclick="FormCheckPoints()" value="отправить">
        </div>
        <div class="elem">
            <p id="errorFields">Ошибка ввода, заполнены не все поля</p>
        </div>
    </form>
</div>
<div class="picture">
    <canvas width="400" height="400" id="canvas" style="display: none"></canvas>
</div>
<div id="xycoordinates"></div>
<div class="result">
    <div id="message">
        <h2>
        </h2>
    </div>
    <table>
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
        <jsp:useBean id="table" class="drukhary.laba_2.AreaCheckingModel.Beans.Table" scope="application"/>
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
</div>
<script>
    <%@include file="../resources/js/script.js"%>
</script>
</body>
</html>