package hiber.model;

import javax.persistence.*;

@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "model")
    private String model;

    @Override
    public String toString() {
        return model + ", series = " + series;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Column (name = "series")
    private int series;

    public Car (){

    }

    public Car (String model, int series){
        this.series = series;
        this.model = model;
    }

}
