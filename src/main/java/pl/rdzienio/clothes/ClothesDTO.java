package pl.rdzienio.clothes;

public class ClothesDTO {

    private Integer id;
    private String name;
    private String category;
    private Integer waterproof;
    private Integer temperature;
    private Integer wind;

    public ClothesDTO() {
    }

    public ClothesDTO(Integer id, String name, String category, Integer waterproof, Integer temperature, Integer wind) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.waterproof = waterproof;
        this.temperature = temperature;
        this.wind = wind;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getWaterproof() {
        return waterproof;
    }

    public void setWaterproof(Integer waterproof) {
        this.waterproof = waterproof;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWind() {
        return wind;
    }

    public void setWind(Integer wind) {
        this.wind = wind;
    }
}
