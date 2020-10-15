/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        
        List<Country> result = new ArrayList<>();
        
        
        try(Connection c =connect()) {
            
            Statement stmt = c.createStatement();
            
            
            stmt.execute("select*from country");
           
            ResultSet rs = stmt.getResultSet();
            
            
            while (rs.next()) {      
                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nationality =rs.getString("nationality");
                
                
                result.add(new Country(id, name, nationality));
                
                
            }
            
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        
        
        
        
        
        
         return result;
    }
    
}
