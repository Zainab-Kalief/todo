<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>Create new item</h1>
<%--@elvariable id="newItem" type="com.wuraalese.todo.models.List"--%>

<form:form  method="POST" action="/list" modelAttribute="newItem">
    <form:hidden path="id"/>
    <form:input path="item" />
    <select name ="user">
        <c:forEach items="${ users }" var="user">
            <c:out value="${ user}"/>
            <option value=<c:out value="${ user.id}"/> >
                <c:out value="${ user.name }"/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" name="" value="Create List">
</form:form>
</body>
</html>