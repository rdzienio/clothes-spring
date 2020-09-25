package pl.rdzienio.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity<List<Clothes>> getAllClothes(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ClothesDTO> getById(@PathVariable Integer id){
        logger.info("Got id {}",  id);
        Clothes gotById = service.getById(id);
        logger.info("Found with id {}: {}", id, gotById.getName());
        return ResponseEntity.ok(converter.fromClothes(gotById));
    }
}
