package com.company.dto;

import com.company.entity.Skill;

public class SkillDTO {

    private Integer id; // id 1 ,PHP
    private String name;

    public SkillDTO() {
    }

    public SkillDTO(Skill skill) {  // id 1 PHP
        this.id = skill.getId();
        this.name = skill.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
