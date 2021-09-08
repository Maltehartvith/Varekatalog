package com.example.demo.Repository;

import com.example.demo.Model.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VareRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Vare> showAllVare(){
        String sql="SELECT * FROM vare";
        RowMapper<Vare> rowMapper=new BeanPropertyRowMapper<>(Vare.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    public Vare findVareById(int id){
        String sql="SELECT * FROM vare WHERE id = ?";
        RowMapper<Vare> rowMapper=new BeanPropertyRowMapper<>(Vare.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);

    }
    public Vare createVare(Vare v){
        String customerSql="INSERT INTO vare (name, price) VALUES (?, ?)";
        jdbcTemplate.update(customerSql, v.getName(), v.getPrice());
        return null;
    }
    public Vare updateVare(Vare v){
        String sql="UPDATE vare SET name = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, v.getName(), v.getPrice() ,v.getId());
        return null;
    }
    public boolean deleteVare(int id){
        String sql="DELETE FROM vare WHERE id = ?";
        return jdbcTemplate.update(sql,id) > 0;
    }
}
