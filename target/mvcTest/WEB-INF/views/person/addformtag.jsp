<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 07.08.18
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false"
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add person taglib</title>
</head>
<body>
<form:form method="post"
           modelAttribute="person">
    <div>
        <form:label path="login">Login</form:label>
        <form:input  path="login" /><br>
    </div>
    <div>
        <form:label path="password">Password</form:label>
        <form:password  path="password" /><br>
    </div>
    <div>
        <form:label path="email">Email</form:label>
        <form:input type="email" path="email" /><br>
    </div>
    <div>
        <form:label path="personDetails.firstName">FirstName</form:label>
        <form:input type="firstName" path="personDetails.firstName" /><br>
    </div>
    <div>
        <form:label path="personDetails.lastName">LastName</form:label>
        <form:input type="lastName" path="personDetails.lastName" /><br>
    </div>
    <div>
        Male: <form:radiobutton path="personDetails.gender" value="Male"/>
        Female: <form:radiobutton path="personDetails.gender" value="Female"/>
    </div>
    <div>
        <form:select path="personDetails.country" items="${countryItems}" />
    </div>
    <div>
        <form:textarea path="personDetails.notes"/>
    </div>
    <div>
        <form:checkbox path="personDetails.mailingList"/>
    </div>
 <div>
     <form:select path="personDetails.programmingSkills" items="${programmingSkills}" multiple="true"/>
 </div>
    <div>
        <form:checkboxes  path="personDetails.hobbies" items="${hobbies}"/>
    </div>
    <input type="submit" value="Save">
</form:form>

</form>
</body>
</html>
