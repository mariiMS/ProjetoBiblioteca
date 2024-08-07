package com.biblioteca.repository;

import com.biblioteca.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Admin> adminRowMapper = new RowMapper<Admin>() {
        @Override
        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
            Admin admin = new Admin();
            admin.setId(rs.getLong("id"));
            admin.setNome(rs.getString("nome"));
            admin.setUsername(rs.getString("username"));
            admin.setSenha(rs.getString("senha"));
            return admin;
        }
    };

    public List<Admin> findAll() {
        String sql = "SELECT * FROM admin";
        return jdbcTemplate.query(sql, adminRowMapper);
    }

    public Optional<Admin> findById(Long id) {
        String sql = "SELECT * FROM admin WHERE id = ?";
        Admin admin = jdbcTemplate.queryForObject(sql, new Object[]{id}, adminRowMapper);
        return Optional.ofNullable(admin);
    }

    public Admin save(Admin admin) {
        if (admin.getId() == null) {
            String sql = "INSERT INTO admin (nome, username, senha) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, admin.getNome(), admin.getUsername(), admin.getSenha());
        } else {
            String sql = "UPDATE admin SET nome = ?, username = ?, senha = ? WHERE id = ?";
            jdbcTemplate.update(sql, admin.getNome(), admin.getUsername(), admin.getSenha(), admin.getId());
        }
        return admin;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM admin WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
