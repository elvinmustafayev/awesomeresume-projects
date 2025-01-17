/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.resume.util.ControllerUtil;
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
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

   private UserDaoInter userDao = Context.instanceUserDao();
   private static BCrypt.Verifyer  verifyer= BCrypt.verifyer();
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


             request.getRequestDispatcher("login.jsp").forward(request,response);



         }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = userDao.findByEmail(email);

            if (user == null) {
                throw new IllegalArgumentException("User doesn't exist");

            }

            BCrypt.Result rs = verifyer.verify(password.toCharArray(),user.getPassword().toCharArray());

            if (!rs.verified) {
                throw new IllegalArgumentException(" password is incorrect");

            }


            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("users");
        } catch(Exception ex){

            ControllerUtil.errorPage(response,ex);

        }

    }
  
    }
