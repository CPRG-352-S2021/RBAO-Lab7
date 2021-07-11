<%-- 
    Document   : users
    Created on : Jul 6, 2021, 10:55:57 AM
    Author     : 840288
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users JDBC</title>
    </head>
    <body>
        <c:if test="${selectedAcc ne null}">
            <h2>Add User</h2>
            <form method="POST" action="users">
                <div>
                    <input type="email" name="emailADD" value="" placeholder = "Email">
                    <br>
                    <input type="text" name="firstName" value="" placeholder="First Name">
                    <br>
                    <input type="text" name="lastName" value="" placeholder = "Last Name">
                    <br>
                    <input type="password" name="password" value="" placeholder = "Password">
                    <br>
                    <select style="height:22px;width:175px;margin-top:5px">
                        <option value = "1">system admin</option>
                        <option value = "2">regular user</option>
                        <option value = "3">company admin</option> 
                    </select>
                    <br>
                    <select style="height:22px;width:175px;margin-top:5px" >
                        <option value = "True">Active</option>
                        <option value = "False">Not Active</option>
                    </select>
                    <br>
                    <input type="hidden" name="action" value="save">
                    <input  style="height:21px;width:176px;margin-top:5px" type="submit" value="Save">
                </div>
            </form>
        </c:if>
    </div>
    <h2>Manage User</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Active</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${users.getEmail}</td>
                <td>${users.getFirstname}</td>
                <td>${users.getLastname}</td>
                <td>${users.getRole}</td>
                <td>${users.isActive}</td>
                <td>
                    <a href="<c:url value="/account">
                           <c:param name="username" value="${account.username}" />
                       </c:url>">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${selectedAcc ne null}">
        <h2>Edit User</h2>
        <form method="POST" action="users">
            <div>
                <input type="email" name="editEmail" value="" placeholder = "Email">
                <br>
                <input type="text" name="firstName" value="" placeholder="First Name">
                <br>
                <input type="text" name="lastName" value="" placeholder = "Last Name">
                <br>
                <select style="height:21px;width:175px;margin-top:5px" >
                    <option value = "1">system admin</option>
                    <option value = "2">regular user</option>
                    <option value = "3">company admin</option> 
                </select>
                <br>
                <select style="height:22px;width:175px;margin-top:5px" >
                    <option value = "True">Active</option>
                    <option value = "False">Not Active</option>
                </select>
                <br>
                <input type="hidden" name="action" value="edit">
                <input style="height:21px;width:176px;margin-top:5px" type="submit" value="Edit">
            </div>
        </form>
    </form>
    <form action="users" method="POST">
        <input type="hidden" name="action" value="delete">
        <input  style="height:21px;width:176px;margin-top:5px" type="submit" value="Delete">
    </form>
</c:if>
</body>
</html>
