<%@ page import="static java.lang.Float.compare" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Точечка в области</title>
    <link href="style.css" rel="stylesheet">
</head>

<body>


<div id="hatBlock" class="framedBlock">
    <span>Сковородников Дмитрий Алексеевич, Группа P32111, Вариант 1109</span>
</div>


<div id="plotBlock" class="framedBlock">
    <canvas id="plot" width="300px" height="300px"></canvas>
</div>


<div id="errorBlock" class="framedBlock" hidden="true"></div>


<div id="formBlock" class="framedBlock">
    <form id="xyrForm" method="get" action="controller-servlet" name="xyrForm">
        <div id="xDiv" class="wrap">
            <div>X:</div>
            <div>
                <input id="x" name="x" type="radio" style="visibility:hidden; display: none" value="hiddenValue">
                <c:forTokens items="-2.0,-1.5,-1.0,-0.5,0.0,0.5,1.0,1.5,2.0" delims="," var="val">
                    <input id="x" name="x" type="radio" value="${val}">
                    <c:out value="${val}"/>
                </c:forTokens>
            </div>
        </div>
        <div id="yDiv">
            <div>Y:</div>
            <div>
                <input type="text" id="y" name="y" placeholder="-3 < y < 5" maxlength="5">
            </div>
        </div>
        <div id="rDiv">
            <div>R:</div>
            <div>
                <input type="text" id="r" name="r" placeholder="2 < r < 5" maxlength="5">
            </div>
        </div>

        <button id="submitButton" type="submit">
            I'm submit button
        </button>
    </form>
</div>


<div id="resultBlock" class="framedBlock">
    <div id="resultTitle">
        Недавние запросы
    </div>
    <div class="resultTable">
        <table id="resultTable">
            <tr id="hatOfTable">
                <th>№</th>
                <th>Дата и время</th>
                <th>Время выполнения запроса(ns)</th>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Результат</th>
            </tr>
            <c:if test="${sessionScope.collection != null}">
                <c:set var="index" value="1" scope="request"/>
                <c:forEach var="result" items="${sessionScope.collection}">
                    <tr>
                        <td name="resultIndex"><c:out value="${requestScope.index}"/></td>
                        <c:set var="index" value="${requestScope.index+1}" scope="request"/>
                        <td name="resultDateTime">${result.dateTime}</td>
                        <td name="resultExecutionTime">${result.executionTime}</td>
                        <td name="resultX">${result.xyr.x}</td>
                        <td name="resultY">${result.xyr.y}</td>
                        <td name="resultR">${result.xyr.r}</td>
                        <td name="resultResult">${result.result? "YES" : "NO"}</td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </div>
</div>


<script type="text/javascript" src="script.js"></script>


</body>


</html>