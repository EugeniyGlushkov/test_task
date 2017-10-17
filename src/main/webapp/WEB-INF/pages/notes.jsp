<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Note Manager</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        .tg {
            width: 100%; /* Ширина таблицы */
        }
        div {
            max-width: 800px; /* Ограничиваем ширину таблицы */
        }
    </style>
</head>
<body>

<br />
<br />

<h1>Book List</h1>

<%--<c:if test="${!empty listBooks}">--%>

<a href="<c:url value='/notes/showallnotes'/>">All notes</a>
<a href="<c:url value='/notes/showperformed'/>">Only performed</a>
<a href="<c:url value='/notes/showunperformed'/>">Only unperformed</a>

<div><table class="tg">
    <tr>
        <th width="350">Note</th>
        <th width="100"><a href="<c:url value='/notes/sortdate'/>">Date</a></th>
        <th width="120">Performed</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listNotes}" var="note">
        <tr>
            <td>${note.noteName}</td>
            <td>${note.createDate}</td>
            <td><c:if test="${note.performed == true}">Performed</c:if>
                <c:if test="${note.performed == false}">Unperformed</c:if>
            </td>
            <td><a href="<c:url value='/edit/${note.id}'/>">Edit</a> </td>
            <td><a href="<c:url value='/remove/${note.id}'/>">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
</div>

<table>
    <tr>
        <td><a href="<c:url value='/notes/movefirst'/>">first </a></td>
        <td><a href="<c:url value='/notes/moveleft'/>"> <<< </a></td>
        <td align="center">${currentpage} from ${amountpages}</td>
        <td><a href="<c:url value='/notes/moveright'/>"> >>> </a></td>
        <td><a href="<c:url value='/notes/movelast'/>"> last</a></td>
    </tr>
</table>

<br/>
<br/>

<c:url var="addAction" value="/notes/add"/>
<form:form action="${addAction}" commandName="note">
    <table>
        <tr>
            <td width="80">
                <c:if test="${note.id == 0}">New note</c:if>
                <c:if test="${note.id != 0}">Edit note</c:if>
            </td>
            <td width="8">
                <c:if test="${note.id != 0}">
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </c:if>
            </td>
            <td width="200"><form:input size="50" maxlength="255" path="noteName"/></td>
            <td width="120">
                <c:if test="${note.id != 0}"><form:checkbox path="performed"/>Performed</c:if>
            </td>
            <td width="120">
                <c:if test="${note.id != 0}">
                    <input type="submit"
                           value="<spring:message text="Edit note"/>"/>
                </c:if>
                    <c:if test="${note.id == 0}">
                        <input type="submit"
                               value="<spring:message text="Add note"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
