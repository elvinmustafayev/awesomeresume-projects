/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.controller;

import com.company.entity.User;
import com.company.resumedbapp.Context;
import com.company.resumedbapp.dao.inter.UserDaoInter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 *
 * @author HP
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

  private UserDaoInter userDao = Context.instanceUserDao();
 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        
        int id = Integer.valueOf(request.getParameter("id"));

        String action = request.getParameter("action");
        if(action.equals("update")){
        
        String name = request.getParameter("name");
        String surname =request.getParameter("surname");
        
        
        System.out.println("name="+name);
        System.out.println("surname="+surname);
        
        User user = userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        userDao.updateUser(user);
        }else if (action.equals("delete")){
            userDao.removeUser(id);
        }

        response.sendRedirect("users");
        
        
        
        
        
         
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


try {
    String userIdStr = request.getParameter("id");
    if (userIdStr == null || userIdStr.trim().isEmpty()) {


        throw new IllegalArgumentException("id is not specified");
        // getRequestDispatcher("/view/electrics.jsp").forward(req,res);

    }

    Integer userId = Integer.parseInt(userIdStr);


    UserDaoInter userDao = Context.instanceUserDao();

    User u = userDao.getById(userId);

    if (u == null) {
        throw new IllegalArgumentException("There is no user with this id ");
    }
//
         request.setAttribute("owner",true);
         request.setAttribute("user", u);
         request.getRequestDispatcher("userdetail.jsp").forward(request,response);
       } catch(Exception ex){

            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());

             }



         }

  
    }
