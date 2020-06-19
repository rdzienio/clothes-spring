package pl.rdzienio.clothes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final ClothesService service;

    public ClothesController(final ClothesService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Clothes>> getAllClothes(){
        return ResponseEntity.ok(service.getAll());
    }
}
