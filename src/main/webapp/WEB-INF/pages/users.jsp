<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<c:set var="users" value="${users}"/>
        <h1>Users</h1>
        <table border="1" width="25%" cellpadding="5">
            <tr>
                <td><p><b>ID</b></p></td>
                <td><p><b>First name</b></p></td>
                <td><p><b>Last name</b></p></td>
                <td><p><b>Actions</b></p></td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>
                        <form action="/delete" method="post">
                        <button name="id" value="${user.id}" type="submit" onclick='this.form.submit()'>Delete</button>
                        </form>
                        <form action="/edit" method="post">
                            <button name = "id" value = "${user.id}" type="submit" onclick='this.form.submit()'>Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
<c:if test="${isVisible == true}" var="isVisible">
    <form action="/edit" method="post">
        Set new First Name
        <input type="text" name="newFirstName">
        Set new Last Name
        <input type="text" name="newLastName">
        <input type="submit" name="submit" value="Save">
    </form>
</c:if>
<h1>Add new user</h1>
<p>
    <big><font color="red"><c:out value="${add}"> </c:out></font></big>
</p>
<form action="/add" method="post">
    <p>
        <input type="text" name="firstName" placeholder="First name">
    </p>
    <p>
        <input type="password" name="lastName" placeholder="Last name">
    </p>
    <input type = "submit" name = "submit" value = "Add">
</form>
</body>
</html>


