package com.biblioteca.repository;

import com.biblioteca.model.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepository {

    private final JdbcTemplate jdbcTemplate;

    public LivroRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class LivroRowMapper implements RowMapper<Livro> {
        @Override
        public Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Livro livro = new Livro();
            livro.setId(rs.getLong("id"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            livro.setAno(rs.getInt("ano"));
            return livro;
        }
    }

    public List<Livro> findAll() {
        String sql = "SELECT * FROM livro";
        return jdbcTemplate.query(sql, new LivroRowMapper());
    }

    public Optional<Livro> findById(Long id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try {
            Livro livro = jdbcTemplate.queryForObject(sql, new Object[]{id}, new LivroRowMapper());
            return Optional.ofNullable(livro);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Livro save(Livro livro) {
        if (livro.getId() == null) {
            String sql = "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, livro.getTitulo(), livro.getAutor(), livro.getAno());
        } else {
            String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE id = ?";
            jdbcTemplate.update(sql, livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getId());
        }
        return livro;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM livro WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
