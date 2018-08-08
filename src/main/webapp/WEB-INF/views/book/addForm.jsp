<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 07.08.18
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Book form</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
<div>
    <form:label path="title">Title</form:label>
    <form:input path="title" id="title"/>
</div>
    <div>
        <form:label path="authors">authors</form:label>
        <form:select path="authors" items="${authors}"
                     itemLabel="fullName" itemValue="id" multiple="true"/>
    </div>
    <div>
        <form:label path="publisher">publisher</form:label>
        <form:select path="publisher.id" items="${publisher}"
        itemLabel="name" itemValue="id"/>
    </div>
    <div>
        <form:label path="rating">rating</form:label>
        <form:input type="number" path="rating" id="rating"/>
    </div>
    <div>
        <form:label path="description">description</form:label>
        <form:input type="description" path="description" id="rating"/>
    </div>
    <div>
        <form:label path="pages">Pages</form:label>
        <form:input type="number" path="pages" id="pages"/>
    </div>
    <div>
        <form:label path="propostition">Proposition</form:label>
        <form:checkbox path="propostition" id="propostition"></form:checkbox>
    </div>
<input type="submit"><br>



</form:form>
</body>
</html>
