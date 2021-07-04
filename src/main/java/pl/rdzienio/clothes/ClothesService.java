package pl.rdzienio.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    private final ClothesRepository repository;
    Logger logger = LoggerFactory.getLogger(ClothesService.class);

    public ClothesService(final ClothesRepository repository) {
        this.repository = repository;
    }

    public List<Clothes> getAll(){
        return repository.findAll();
    }

    public Clothes getById(Integer id){
        return repository.getOne(id);
    }

    public Clothes saveCloth(Clothes clothToSave){
        logger.info("Got cloth to save: {}", clothToSave.getName());
        var savedCloth = repository.save(clothToSave);
        logger.info("Saved cloth: {}", savedCloth);
        return savedCloth;
    }

    public void removeCloth(Integer idToRemove){
        logger.info("Removing cloth with id: {}", idToRemove);
        var byId = repository.findById(idToRemove);
        if (byId.isPresent()) {
            repository.deleteById(idToRemove);
            logger.info("Deleted cloth: {} {}", idToRemove, byId.get().getName());
        }
        else
            logger.warn("Cloth with id [{}] not found!", idToRemove);
    }

    public List<Clothes> getClothesForRainingWeather(){
        return repository.findClothesByWaterproofGreaterThanEqual(2);
    }

}
