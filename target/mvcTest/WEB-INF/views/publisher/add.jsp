
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Book form</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
   <div>
    <form:label path="name">Name</form:label>
    <form:input path="name" id="name"/>
    <form:errors path="name"></form:errors>
</div>
    <div>
        <form:label path="nip">NIP</form:label>
        <form:input path="nip" id="nip"/>
        <form:errors path="nip"></form:errors>
    </div>
    <div>
        <form:label path="regon">REGON</form:label>
        <form:input path="regon" id="regon"/>
        <form:errors path="regon"></form:errors>
    </div>

    <input type="submit"><br>



</form:form>
</body>
</html>
