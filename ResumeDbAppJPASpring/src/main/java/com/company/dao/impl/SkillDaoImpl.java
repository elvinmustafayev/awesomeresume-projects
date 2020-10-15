/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();

        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select*from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                result.add(new Skill(id, name));

            }

//To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        boolean b = true;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into skill (name) VALUES(?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, skill.getName());
            b=stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }
        return b; //To change body of generated methods, choose Tools | Templates.
    }

}
