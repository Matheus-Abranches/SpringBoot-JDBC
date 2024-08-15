package matheus.projeto_jdbc.Repositories;

import matheus.projeto_jdbc.Models.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CursosRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Cursos> rowMapper = new RowMapper<Cursos>() {
        @Override
        public Cursos mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Cursos cursos = new Cursos();
            cursos.setId(resultSet.getLong("id"));
            cursos.setNome(resultSet.getString("nome"));
            cursos.setConteudo(resultSet.getString("descricao"));
            return cursos;
        }
    };

    public List<Cursos> findAll() {
        String sql = "SELECT * FROM curso";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Cursos> findById(Long id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        Cursos curso = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
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
