package matheus.projeto_jdbc.Repositories;

import matheus.projeto_jdbc.Mappers.CursosMapper;
import matheus.projeto_jdbc.Models.Cursos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CursosRepository {


    private JdbcTemplate jdbcTemplate;

    public CursosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cursos> findAll() {
        String sql = "SELECT * FROM curso";
        return jdbcTemplate.query(sql, new CursosMapper());
    }

    public Optional<Cursos> findById(Long id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        Cursos curso = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CursosMapper());
        return Optional.ofNullable(curso);
    }

    public int save(Cursos curso) {
        String sql = "INSERT INTO curso (nome, descricao) VALUES (?, ?)";
        return jdbcTemplate.update(sql, curso.getNome(), curso.getConteudo());
    }

    public int update(Cursos curso) {
        String sql = "UPDATE curso SET nome = ?, descricao = ? WHERE id = ?";
        return jdbcTemplate.update(sql, curso.getNome(), curso.getConteudo(), curso.getId());
    }

    public int deleteById(Long id){
        String sql = "DELETE FROM curso WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
