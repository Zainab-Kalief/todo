<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>Welcome to To do</h1>
<%--@elvariable id="newUser" type="com.wuraalese.todo.models.User"--%>
<form:form method="POST" action="/user" modelAttribute="newUser">
    <form:hidden path="id"></form:hidden>
    <form:input path="name" /><br>
    <input type="submit" name="" value="Create User">
</form:form>
<a href="/list">New Item</a>
</body>
</html>
