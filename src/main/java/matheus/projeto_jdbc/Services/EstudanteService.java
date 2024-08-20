package matheus.projeto_jdbc.Services;

import matheus.projeto_jdbc.Models.Estudante;
import matheus.projeto_jdbc.Repositories.CursosRepository;
import matheus.projeto_jdbc.Repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    private EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public List<Estudante> findAll() {
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> findById(Long id) {
        return estudanteRepository.findById(id);
    }

    public boolean save(Estudante estudante) {
        return estudanteRepository.save(estudante) > 0;
    }

    public boolean update(Estudante estudante) {
        return estudanteRepository.update(estudante) > 0;
    }

    public boolean deleteById(Long id) {
        return estudanteRepository.deleteById(id) > 0;
    }
}

