package matheus.projeto_jdbc.Controllers;

import matheus.projeto_jdbc.Models.Estudante;
import matheus.projeto_jdbc.Services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    private EstudanteService estudanteService;

    public EstudanteController(EstudanteService cursosService) {
        this.estudanteService = cursosService;
    }

    @GetMapping
    public List<Estudante> getAllEstudantes() {
        return estudanteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> getEstudanteById(@PathVariable Long id) {
        Optional<Estudante> estudante = estudanteService.findById(id);
        if (estudante.isPresent()) {
            return ResponseEntity.ok(estudante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estudante> createEstudante(@RequestBody Estudante estudante) {
        boolean created = estudanteService.save(estudante);
        if (created) {
            return ResponseEntity.ok(estudante);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> updateEstudante(@PathVariable Long id, @RequestBody Estudante estudanteDetails) {
        Optional<Estudante> estudante = estudanteService.findById(id);

        if (estudante.isPresent()) {
            Estudante estudanteEncontrado = estudante.get();
            estudanteEncontrado.setNome(estudanteDetails.getNome());
            estudanteEncontrado.setEmail(estudanteDetails.getEmail());
            boolean updated = estudanteService.update(estudanteEncontrado);

            if (updated) {
                return ResponseEntity.ok(estudanteEncontrado);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudante(@PathVariable Long id) {
        boolean deleted = estudanteService.deleteById(id);

        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

