package com.abhi.springjdbcdemo.repository;

import com.abhi.springjdbcdemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlienRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String sql = "INSERT INTO alien (id, name, age, technology) VALUES (?,?,?,?);";

        int row = jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getAge(), alien.getTechnology());
        System.out.println(row + " row added");
    }

    public List<Alien> findAll() {

        String sql = "SELECT * FROM alien;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setAge(rs.getInt("age"));
            a.setTechnology(rs.getString("technology"));
            return a;
        });
    }
}