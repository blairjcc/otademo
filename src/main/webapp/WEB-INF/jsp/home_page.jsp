<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/read" method="post">
      <fieldset>
        <legend>Information:</legend>
        <label for="fname">Project name:</label><br>
        <select id="project" name="project">
            <option value="0">Select Project</option>
            <option value="1">Customers</option>
        </select>
        <input type="submit" value="Submit">
      </fieldset>
    </form>

<c:if test="${not empty error}">
    <br/>
    <div class="error">${error}</div>
</c:if>

<c:if test="${not empty tickets}">
<div>
<br/>
<table id="customers">
  <tr>
    <th>Ticket Id</th>
    <th>Description</th>
    <th>Status</th>
    <th>Date</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${tickets}" var="ticket">
      <tr>
          <td><c:out value="${ticket.ticketId}"/></td>
          <td><c:out value="${ticket.description}"/></td>
          <td><c:out value="${ticket.status eq 'true' ? 'Closed' : 'Open'}"/></td>
          <td><fmt:formatDate value="${ticket.date}" pattern="MMM-dd-yyyy"/></td>
          <td><a href="/updatePage?id=${ticket.id}">Update</a>&nbsp;&nbsp;&nbsp;<a href="/deletePage?id=${ticket.id}">Delete</a></td>
      </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
       <form action="/createPage">
          <input type="submit" value="Add New">
       </form>
    </td>
  </tr>
</table>
</div>
</c:if>
</div>
</body>
</html>