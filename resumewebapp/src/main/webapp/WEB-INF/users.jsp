<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/users.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script type="text/javascript" src="assets/js/users.js"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



        <title> JSP Page</title>


    </head>
    <body>

<%--      <%--%>

<%--         User user   =  (User) session.getAttribute("loggedInUser");--%>
<%--            if (user==null){--%>
<%--                response.sendRedirect("login");--%>
<%--                return;--%>
<%--            }--%>

<%--      %>--%>

<%--      <%="Welcome, "+user.getName()%>--%>


<div class="container">

             <div class="row" >
                  <div class="col-4">

                      <f:form action="usersm" method="GET" modelAttribute="user">

                <div class="form-group">
                     <label for="name">name:</label>
                      <f:input  onkeyup="writeWhatIamTyping()"
                                path="name"
                                placeholder="Enter name"
                                class="form-control"   />
                                  <form:errors path="name" cssClass="error"/>
                                 </div>
                <div class="control_panel_group">
                      <label for="surname">surname:</label>
                      <f:input
                              path="surname"
                              placeholder="Enter surname"
                              class="form-control"   />
                           <form:errors path="surname" cssClass="error"/>
                         </div>
                         <br>
                <f:button class="btn btn-primary" type="submit"   id="btnsearch">
                                 Search
                      </f:button>


            </f:form>

                  </div>

               </div>

             <div>
        <table class="table">
            <thead>
                   <tr>
                       <th>name</th>
                       <th>surname</th>
                       <th>nationality</th>
                       <th></th>
                       <th></th>

                   </tr>
            </thead>

            <tbody>

               <c:forEach items="${users}" var="u">
             <tr>

                 <td>${u.name}</td>

                 <td>${u.surname}</td>
                 <td>${u.nationality.name}</td>
                    <td style="width:5px ">

                            <input type="hidden" name="id" value="${u.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button class="  btn btn-danger" type="submit" value="delete"
                                  data-toggle="modal" data-target="#exampleModal"

                          onclick="setIdForDelete('${u.id}>')">
                                 <i class="fas fa-trash-alt"></i>
                                              </button>





                    </td>

                 <td style="width:5px ">

                     <form action="userdetail" method="GET">
                         <input type="hidden" name="id" value="${u.id}"/>
                         <input type="hidden" name="action" value="update"/>
                         <button class=" btn btn-secondary " type="submit" value="update" >
                             <i class="fas fa-pen-square"></i>
                         </button>
                     </form>

                 </td>
             </tr>


               </c:forEach>
            </tbody>


        </table>









    </div>




</div>





        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                      Are you sure ?

                    </div>
                    <div class="modal-footer">

                        <form action="userdetail" method="POST">
                            <input type="hidden"  name="id" value="" id="idForDelete">
                            <input type="hidden" name="action" value="delete">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-danger" value="Delete">
                                            </form>
                    </div>
                </div>
            </div>
        </div>






    </body>
</html>
