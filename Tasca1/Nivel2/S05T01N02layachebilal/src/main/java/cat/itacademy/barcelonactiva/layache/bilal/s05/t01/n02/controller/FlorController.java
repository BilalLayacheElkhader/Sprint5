package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.controller;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.dto.dtoFlor;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<String> addFlor(@RequestBody dtoFlor dtoflor) {
        florService.save(dtoflor);
        return ResponseEntity.ok("Flor añadida");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFlor(@RequestBody dtoFlor dtoflor) {
        florService.updateFlor(dtoflor);
        return ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable int id) {
        florService.deleteFlor(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<dtoFlor> getOne(@PathVariable int id) {
        dtoFlor dtoflor = florService.getById(id);
        return ResponseEntity.ok(dtoflor);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<dtoFlor>> allFlor() {
        List<dtoFlor> flors = florService.getAllFlor();
        return ResponseEntity.ok(flors);
    }
}
