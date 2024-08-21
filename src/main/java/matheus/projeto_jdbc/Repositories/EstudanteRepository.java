package matheus.projeto_jdbc.Repositories;

import matheus.projeto_jdbc.Mappers.EstudanteMapper;
import matheus.projeto_jdbc.Models.Estudante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class EstudanteRepository {

    private JdbcTemplate jdbcTemplate;

    public EstudanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Estudante> findAll() {
        String sql = "SELECT * FROM estudante";
        return jdbcTemplate.query(sql, new EstudanteMapper());
    }

    public Optional<Estudante> findById(Long id) {
        String sql = "SELECT * FROM estudante WHERE id = ?";
        Estudante estudante = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EstudanteMapper());
        return Optional.ofNullable(estudante);
    }

    public int save(Estudante estudante) {
        String sql = "INSERT INTO estudante (nome, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, estudante.getNome(), estudante.getEmail());
    }

    public int update(Estudante estudante) {
        String sql = "UPDATE estudante SET nome = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, estudante.getNome(), estudante.getEmail(), estudante.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM estudante WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
