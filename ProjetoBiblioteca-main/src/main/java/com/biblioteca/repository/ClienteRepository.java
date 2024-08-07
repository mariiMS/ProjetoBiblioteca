package com.biblioteca.repository;

import com.biblioteca.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Cliente> clienteRowMapper = new RowMapper<Cliente>() {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            cliente.setDataNascimento(rs.getDate("data_nascimento"));
            cliente.setCep(rs.getString("cep"));
            return cliente;
        }
    };

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, clienteRowMapper);
    }

    public Optional<Cliente> findById(Long id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = jdbcTemplate.queryForObject(sql, new Object[]{id}, clienteRowMapper);
        return Optional.ofNullable(cliente);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            String sql = "INSERT INTO cliente (nome, email, telefone, cpf, rg, data_nascimento, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getRg(), cliente.getDataNascimento(), cliente.getCep());
        } else {
            String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, cpf = ?, rg = ?, data_nascimento = ?, cep = ? WHERE id = ?";
            jdbcTemplate.update(sql, cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getRg(), cliente.getDataNascimento(), cliente.getCep(), cliente.getId());
        }
        return cliente;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
