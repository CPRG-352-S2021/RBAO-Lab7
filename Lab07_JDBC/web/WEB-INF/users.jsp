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
        <link rel="stylesheet" href="./assets/css/styles.css">
    </head>
    <body>
        <div class="header-section">
            <div class="header-section-1">
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
                        <select style="height:22px;width:175px">
                            <option value = "1">aystem admin</option>
                            <option value = "2">regular User</option>
                            <option value = "3">company admin</option> 
                        </select>
                        <br>
                        <input  style="height:21px;width:176px;margin-top:5px" type="submit" value="Save" >
                    </div>
                </form>
            </div>

            <div class="header-section-2">
                <h2>Manage User</h2>
            </div>

            <div class="header-section-3">
                <h2>Edit User</h2>
                <form method="POST" action="users">
                    <div>
                        <input type="email" name="emailADD" value="" placeholder = "Email">
                        <br>
                        <input type="text" name="firstName" value="" placeholder="First Name">
                        <br>
                        <input type="text" name="lastName" value="" placeholder = "Last Name">
                        <br>
                        <select style="height:21px;width:175px">
                            <option value = "1">system admin</option>
                            <option value = "2">regular user</option>
                            <option value = "3">company admin</option> 
                        </select>
                        <br>
                         <input style="height:21px;width:176px;margin-top:5px" type="submit" value="Save" >
                    </div>
                </form>
            </div>
        </div>


    </body>
</html>
