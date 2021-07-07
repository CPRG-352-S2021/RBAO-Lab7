<%-- 
    Document   : users
    Created on : Jul 6, 2021, 10:55:57 AM
    Author     : 840288
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <form method="GET" action="users">

            <input type="radio" name="active[]" value="">
            <label>Active</label>
            <input type="radio" name="active[]" value="">
            <label>Inactive</label>
            <br>
            <label>Email</label>
            <input type="email" name="emailADD" value="">
            <br>
            <label>First Name</label>
            <input type="text" name="name" size="15" value="">
            <br>
            <label>Last Name</label>
            <input type="text" name="surname" size="15" value="">
            <br>
            <label>Password</label>
            <input type="password" name="pwd" value="">
            <br>        
            <label for="Role">Role</label>
            <select>
            <option value="1">system  admin</option>
            <option value="2">regular user</option>
            <option value="3">company admin</option>
            </select>
        </form>

    </body>
</html>
