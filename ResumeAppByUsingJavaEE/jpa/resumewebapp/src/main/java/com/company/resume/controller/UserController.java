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
@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {


 
  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


             request.getRequestDispatcher("users.jsp").forward(request,response);



         }

  
    }