package pl.rdzienio.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final ClothesService service;
    private final ClothesConverter converter;
    Logger logger = LoggerFactory.getLogger(ClothesController.class);

    public ClothesController(final ClothesService service, ClothesConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Clothes>> getAllClothes() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothesDTO> getById(@PathVariable Integer id) {
        logger.info("Got id {}", id);
        Clothes gotById = service.getById(id);
        logger.info("Found with id {}: {}", id, gotById.getName());
        return ResponseEntity.ok(converter.fromClothes(gotById));
    }

    @PostMapping("/save")
    public ClothesDTO saveCloth(@RequestBody ClothesDTO clothToSave) {
        logger.info("Saving cloth: {}", clothToSave.getName());
        var cloth = converter.fromDTO(clothToSave);
        return converter.fromClothes(service.saveCloth(cloth));
    }

    @DeleteMapping("/remove/{id}")
    public int removeClothById(@PathVariable Integer id){
        logger.info("Got id to remove: {}", id);
        service.removeCloth(id);
        return id;
    }
}
