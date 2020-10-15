/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resumedbapp;


import com.company.entity.Country;
import com.company.entity.User;
import com.company.resumedbapp.dao.inter.UserDaoInter;


public class Main {

   

    public static void main(String[] args) throws Exception {
           UserDaoInter  dao=Context.instanceUserDao();
      
               
        
           User u = dao.findByEmail("sarkhanrasullu@gmail.com");
                System.out.println("u.name="+u.getName());
          
          
            
        }
       
//        
//        
//      
//        
//        System.out.println( dao.getAllSkillByUserId( 5));
       
      
    }


