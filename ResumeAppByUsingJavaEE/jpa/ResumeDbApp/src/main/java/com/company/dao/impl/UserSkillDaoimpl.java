/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.resumedbapp.dao.inter.AbstractDAO;

import com.company.resumedbapp.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserSkillDaoimpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");

        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        Skill skill = new Skill(skillId, skillName);

        User user = new User(userId);
        return null;
        /*
         
         
         onagore null yazilib ki user obyekti var id ile birlikde ,elave id ye ehtiyac 
         yoxdu!!
         
         */
    }

    /**
     *
     *
     *
     * @return
     */
    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        /////////////////////////////////
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT" 
                    + "	us.id as userSkillId,"
                    + "	u.*,"
                    + "	us.skill_id,"
                    + "	s.NAME AS skill_name,"
                    + "	us.power "
                    + "FROM"
                    + "	user_skill us"
                    + "	LEFT JOIN USER u ON us.user_id = u.id"
                    + "	LEFT JOIN skill s ON us.skill_id = s.id "
                    + "WHERE "
                    + " us.user_id = ?");
            stmt.setInt(1, userId);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                UserSkill u = getUserSkill(rs);

                result.add(u);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Burada databese -e qosulur oradan id-ni name -i surname -i phone-u email-i cekir 
        ve yuxarida yaradilan Arraylistin add metoduna gonderilir.. ve bir user arraylisti yaradilir
        
         */
        return result;
    }

    @Override
    public boolean removeSkill(int id) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        boolean b = true;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("Insert into user_skill(skill_id ,user_id,power) values(?,?,?)");
            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }
        return b;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        Connection conn;
        boolean b =true;
        try {
            
            conn=connect();
            PreparedStatement stmt = conn.prepareStatement("UPDATE user_skill SET skill_id=?,user_id=?,power=? WHERE id=?;");
             stmt.setInt(1, u.getSkill().getId());
             stmt.setInt(2, u.getUser().getId());
             stmt.setInt(3, u.getPower());
             stmt.setInt(4, u.getId());
             stmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
            b=false;
        }
        
        
            return b;
        
         //To change body of generated methods, choose Tools | Templates.
    }

}
