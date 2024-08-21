package matheus.projeto_jdbc.Mappers;

import matheus.projeto_jdbc.Models.Cursos;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursosMapper implements RowMapper<Cursos> {

    @Override
    public Cursos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cursos curso = new Cursos();
        curso.setId(rs.getLong("id"));
        curso.setNome(rs.getString("nome"));
        curso.setConteudo(rs.getString("descricao"));
        return curso;
    }
}

