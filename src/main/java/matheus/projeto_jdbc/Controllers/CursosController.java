package matheus.projeto_jdbc.Controllers;

import matheus.projeto_jdbc.Models.Cursos;
import matheus.projeto_jdbc.Services.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> getAllCursos() {
        return cursosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> getCursoById(@PathVariable Long id) {
        Optional<Cursos> cursos = cursosService.findById(id);
        if (cursos.isPresent()) {
            return ResponseEntity.ok(cursos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cursos> createCursos(@RequestBody Cursos cursos) {
        boolean created = cursosService.save(cursos);
        if (created) {
            return ResponseEntity.ok(cursos);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCursos(@PathVariable Long id, @RequestBody Cursos cursosDetails) {
        Optional<Cursos> cursos = cursosService.findById(id);

        if (cursos.isPresent()) {
            Cursos cursosEncontrado = cursos.get();
            cursosEncontrado.setNome(cursosDetails.getNome());
            cursosEncontrado.setConteudo(cursosDetails.getConteudo());
            boolean updated = cursosService.update(cursosEncontrado);

            if (updated) {
                return ResponseEntity.ok(cursosEncontrado);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCursos(@PathVariable Long id) {
        boolean deleted = cursosService.deleteById(id);

        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


