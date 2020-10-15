/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;

import com.company.resumedbapp.dao.inter.AbstractDAO;
import com.company.resumedbapp.dao.inter.EmploymentHistoryDaoInter;
import com.mysql.cj.x.protobuf.MysqlxSql;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class EmploymentHistoryDaoimpl extends AbstractDAO implements EmploymentHistoryDaoInter {

  

  

  
   

     

  

   
    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        String header =rs.getString("header");
        String jobDescription =rs.getString("job_description");
        
        Date beginDate=rs.getDate("begin_date");
        Date endDate =rs.getDate("end_date");
        int userId=rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
           return emp;
    }
    
    /**
     *
     *
     * 
     * @param userId
     * @return 
     */
     public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
           List<EmploymentHistory> result = new ArrayList<>();
        /////////////////////////////////
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select*from employment_history where user_id=?");
                 stmt.setInt(1, userId);
                    
                 stmt.execute();
                 ResultSet rs = stmt.getResultSet(); /* burda uje resultimiz var hemin result rs 
                 
                         gonderilir yuxari 
                 
                 
                 */ 

            while (rs.next()) {

              EmploymentHistory emp = getEmploymentHistory( rs);

                result.add(emp);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Burada databese -e qosulur oradan id-ni name -i surname -i phone-u email-i cekir 
        ve yuxarida yaradilan Arraylistin add metoduna gonderilir.. ve bir user arraylisti yaradilir
        
         */
        return result;
    }

     
     
     public boolean insertEmploymentHistory(EmploymentHistory emp){
         
        try (Connection con = connect()){
            
            
            PreparedStatement stmt = con.prepareStatement("insert into employment_history(header,begin_date,end_date,job_description,user_id) values(?,?,?,?,?)");
            stmt.setString(1, emp.getHeader());
//            stmt.setDate(2, emp.getBegindDate());
//            stmt.setDate(3, emp.getEndDate());
            stmt.setString(4, emp.getJobDescription());
            
           
            
            
            stmt.setInt(5,emp.getUser().getId()); /*Compositionin tetbiqi userin idisinin alinmasi 
            rahatlasir */
             
              
           

            
            return stmt.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
                  }
           
         
     }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory emp) {
       
        
        try(Connection c=connect()){
            
            PreparedStatement stmt= c.prepareStatement("update employment_history set header=?,begin_date=?,end_date=?,job_description=?,user_id=?");
            stmt.setString(1, emp.getHeader());
//            stmt.setDate(2, emp.getBegindDate());
//            stmt.setDate(3, emp.getEndDate());
            stmt.setString(4, emp.getJobDescription());
            stmt.setInt(5, emp.getUser().getId());
            return stmt.execute();
        } catch (Exception ex) {
           ex.printStackTrace();
           return false;
        }
        
    }
     
     
     
     
  
}
