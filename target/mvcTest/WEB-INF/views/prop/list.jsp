<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 07.08.18
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Lista books</title>
</head>
<body>
<ul>
    <c:forEach var="book" items="${prop}" >
        <li>
            ${book.title} -${book.description}<a href="edit/${book.id}">Edycja</a><a href="delete/${book.id}">Delete</a>
        </li>

    </c:forEach>

</ul>

</body>
</html>
