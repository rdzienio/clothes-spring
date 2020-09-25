package pl.rdzienio.clothes;

import org.springframework.stereotype.Component;

@Component
public class ClothesConverter {

    ClothesDTO fromClothes(Clothes toConvert) {
        return new ClothesDTO(
                toConvert.getId(),
                toConvert.getName(),
                toConvert.getCategory(),
                toConvert.getWaterproof(),
                toConvert.getTemperature(),
                toConvert.getWind()
        );
    }

    Clothes fromDTO(ClothesDTO toConvert) {
        return new Clothes(
                toConvert.getId(),
                toConvert.getName(),
                toConvert.getCategory(),
                toConvert.getWaterproof(),
                toConvert.getTemperature(),
                toConvert.getWind()
        );
    }
}
