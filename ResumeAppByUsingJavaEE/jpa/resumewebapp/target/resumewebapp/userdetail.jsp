<%-- 
    Document   : user
    Created on : Apr 26, 2020, 11:37:53 PM
    Author     : HP
--%>

<%@page import="com.company.entity.User"%>
<%@page import="com.company.resumedbapp.Context"%>
<%@page import="com.company.resumedbapp.dao.inter.UserDaoInter"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JSP Page</title>
    </head>
    <body>










        <%


            User u =(User)request.getAttribute("user");



        %>
        <div>

            <form action="userdetail"  method="POST">

                <input type="hidden" name="id" value="<%=u.getId()%>">

                <label for="name">name:</label>
                <input type="text" name="name" value="<%=u.getName()%>"/>
                <br>
                <label for="surname">Surname:</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>"/>

                <input type="submit" name="action" value="update"/>


            </form>
        </div>

    </body>
</html>
