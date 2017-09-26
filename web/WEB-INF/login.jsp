<%-- 
    Document   : login
    Created on : Sep 18, 2017, 2:55:48 PM
    Author     : 698437
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
        <h1>Login</h1>
        <div>
            <form action="Login" method="POST">
                Username: <input type="text" name="username" ${username}><br>
                Password: <input type="password" name="password" ${password}><br>
                <input type="submit" value="Login">
            </form>
        ${errorMessage}
        ${logout}
    
<c:import url="/includes/footer.html" />

