package pl.rdzienio.clothes;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
public class Clothes {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    private String name;
    private String category;
    private Integer waterproof;
    private Integer temperature;
    private Integer wind;

    public Clothes() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public Integer getWaterproof() {
        return waterproof;
    }

    public void setWaterproof(final Integer waterproof) {
        this.waterproof = waterproof;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(final Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWind() {
        return wind;
    }

    public void setWind(final Integer wind) {
        this.wind = wind;
    }
}
