package matheus.projeto_jdbc.Controllers;

import matheus.projeto_jdbc.Models.Cursos;
import matheus.projeto_jdbc.Services.CursosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

    private CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @GetMapping
    public List<Cursos> getAllCursos() {
        return cursosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> getCursoById(@PathVariable Long id) {
       return cursosService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cursos> createCursos(@RequestBody Cursos cursos) {
      return cursosService.save(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCursos(@PathVariable Long id, @RequestBody Cursos cursosDetails) {
        Cursos updatedCurso = cursosService.update(id, cursosDetails);
        if (updatedCurso != null) {
            return ResponseEntity.ok(updatedCurso);
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


