package matheus.projeto_jdbc.Services;

import matheus.projeto_jdbc.Models.Cursos;
import matheus.projeto_jdbc.Repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    public List<Cursos> findAll() {
        return cursosRepository.findAll();
    }

    public Optional<Cursos> findById(Long id) {
        return cursosRepository.findById(id);
    }

    public boolean save(Cursos cursos) {
        return cursosRepository.save(cursos) > 0;
    }

    public boolean update(Cursos cursos) {
        return cursosRepository.update(cursos) > 0;
    }

    public boolean deleteById(Long id) {
        return cursosRepository.deleteById(id) > 0;
    }
}

