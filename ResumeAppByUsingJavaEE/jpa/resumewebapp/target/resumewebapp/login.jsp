<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.05.2020
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body class="login_background">


<form action="login" method="POST">

    <div class="col-4 container login_fix_">

        <center>


            <h1>Login</h1>
        </center>

        <div class="form-group">

            <label >Email address</label>
            <input type="email" class="form-control" placeholder="email@example.com" name="email">

        </div>

        <div class="form-group">

            <label >Password</label>
            <input type="password" class="form-control" placeholder="Password" name="password">

        </div>

            <button type="submit" class="btn btn-primary" name="login">Login</button>

    </div>



</form>

</body>
</html>
