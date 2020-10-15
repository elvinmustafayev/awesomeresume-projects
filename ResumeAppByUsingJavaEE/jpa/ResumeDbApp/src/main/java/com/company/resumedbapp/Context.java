/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resumedbapp;

import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoimpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoimpl;
import com.company.resumedbapp.dao.inter.CountryDaoInter;
import com.company.resumedbapp.dao.inter.EmploymentHistoryDaoInter;
import com.company.resumedbapp.dao.inter.SkillDaoInter;
import com.company.resumedbapp.dao.inter.UserDaoInter;
import com.company.resumedbapp.dao.inter.UserSkillDaoInter;

/**
 *
 * @author HP
 */
public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    
    
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoimpl();
    }
    
    
    
       
    public static EmploymentHistoryDaoInter instanceEmploymentHistory(){
        return new EmploymentHistoryDaoimpl();
    }
    
    
    public static SkillDaoInter intanceSkillDao(){
        return new SkillDaoImpl();
    }
    
    
    public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
    }
}
