/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resumedbapp.dao.inter;


import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author HP
 */
public interface EmploymentHistoryDaoInter {
   
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    public boolean  insertEmploymentHistory(EmploymentHistory emp);
    public boolean updateEmploymentHistory(EmploymentHistory emp);
}
