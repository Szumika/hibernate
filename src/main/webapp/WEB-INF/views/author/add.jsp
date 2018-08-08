
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
    </div>
    <div>
        <form:label path="lastname">Surname</form:label>
        <form:input path="lastname" id="lastname"/>
    </div>

    <input type="submit"><br>



</form:form>
</body>
</html>
