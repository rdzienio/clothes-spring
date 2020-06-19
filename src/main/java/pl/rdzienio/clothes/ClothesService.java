package pl.rdzienio.clothes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {

    private ClothesRepository repository;

    public ClothesService(final ClothesRepository repository) {
        this.repository = repository;
    }

    public List<Clothes> getAll(){
        return repository.findAll();
    }

}
