package matheus.projeto_jdbc.Services;

import matheus.projeto_jdbc.Models.Cursos;
import matheus.projeto_jdbc.Repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    private CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public List<Cursos> findAll() {
        return cursosRepository.findAll();
    }

    public ResponseEntity<Cursos> findById(Long id) {
        Optional<Cursos> cursosFindId = cursosRepository.findById(id);
        if (cursosFindId.isPresent()) {
            return ResponseEntity.ok(cursosFindId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Cursos> save (Cursos cursos){
        int resultado = cursosRepository.save(cursos);
        if (resultado > 0) {
            return ResponseEntity.ok(cursos);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    public Cursos update(Long id, Cursos cursosDetails) {
        Optional<Cursos> cursosOptional = cursosRepository.findById(id);

        if (cursosOptional.isPresent()) {
            Cursos cursosEncontrados = cursosOptional.get();
            cursosEncontrados.setNome(cursosDetails.getNome());
            cursosEncontrados.setConteudo(cursosDetails.getConteudo());

            boolean updated = cursosRepository.update(cursosEncontrados) > 0;
            if (updated) {
                return cursosEncontrados;
            } else {

                return null;
            }
        }else {

            return null;
        }
    }

    public boolean deleteById(Long id) {
        if (cursosRepository.findById(id).isPresent()) {
            return cursosRepository.deleteById(id) > 0;
        }
        return false;
    }
}

