

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Admin Login</title>
<%--    <link rel="stylesheet" href="assets/css/users.css">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body class="login_background">


<form action="logout" method="POST">

    <div class="col-4 container login_fix_">


        <input type="hidden"  name="${_csrf.parameterName}"
           value="${_csrf.token}"  >

            <button type="submit" class="btn btn-primary" >Logout</button>

    </div>



</form>

</body>
</html>
