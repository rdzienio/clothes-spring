package pl.rdzienio.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer> {

    List<Clothes> findClothesByWaterproofGreaterThanEqual(Integer waterproof);
}
