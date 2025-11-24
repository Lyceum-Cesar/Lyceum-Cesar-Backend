package com.Lyceum.Cesar.Controller;



import com.Lyceum.Cesar.Models.Matricula;
import com.Lyceum.Cesar.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin("*")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping
    public List<Matricula> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Matricula matricular(@RequestBody Matricula matricula) {
        return repository.save(matricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizarNotas(@PathVariable Long id, @RequestBody Matricula dadosAtualizados) {
        return repository.findById(id)
                .map(matricula -> {
                    if(dadosAtualizados.getMedia() != null) matricula.setMedia(dadosAtualizados.getMedia());
                    if(dadosAtualizados.getFaltas() != null) matricula.setFaltas(dadosAtualizados.getFaltas());
                    return ResponseEntity.ok(repository.save(matricula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarMatricula(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}