package matheus.projeto_jdbc.Mappers;

import matheus.projeto_jdbc.Models.Estudante;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudanteMapper implements RowMapper<Estudante> {

    @Override
    public Estudante mapRow(ResultSet rs, int rowNum) throws SQLException {
        Estudante estudante = new Estudante();
        estudante.setId(rs.getLong("id"));
        estudante.setNome(rs.getString("nome"));
        estudante.setEmail(rs.getString("email"));
        return estudante;
    }
}
