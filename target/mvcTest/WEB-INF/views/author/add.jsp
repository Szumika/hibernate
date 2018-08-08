
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Book form</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <div>
        <form:label path="firstname">Name</form:label>
        <form:input path="firstname" id="firstname"/>
        <form:errors path="firstname"></form:errors>
    </div>
    <div>
        <form:label path="lastname">Surname</form:label>
        <form:input path="lastname" id="lastname"/>
        <form:errors path="lastname"></form:errors>
    </div>
    <div>
        <form:label path="PESEL">Pesel</form:label>
        <form:input path="PESEL" id="PESEL"/>
        <form:errors path="PESEL"></form:errors>
    </div>
    <div>
        <form:label path="email">email</form:label>
        <form:input path="email" id="email"/>
        <form:errors path="email"></form:errors>
    </div>

    <input type="submit"><br>



</form:form>
</body>
</html>
