<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form action="${formAction}" method="POST" modelAttribute="ticket">
      <fieldset>
        <legend>${pageTitle}:</legend>
        <br/>
        <form:input type="hidden" path="id"/>
        <form:label path="ticketId">Ticket Id:</form:label><br>
        <form:input type="text" path="ticketId"/>
        <form:label path="description">Description:</form:label><br>
        <form:input type="text" path="description"/>
        <form:label path="status">Ticket Status:</form:label><br>
        <form:select path="status">
            <form:option value="false">Open</form:option>
            <form:option value="true">Closed</form:option>
        </form:select>
        <input type="submit" value="${pageTitle}">
      </fieldset>
    </form:form>
</div>
</body>
</html>