package nl.vijfhart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CURSUS")
public class Course {

    private int id;
    private String name;
    private String description;
    private int duration;
    private int price;
    private List<Category> categories = new ArrayList<>();

    public Course() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAAM")
    public String getName() {
        return name;
    }

    public void setName(String naam) {
        this.name = naam;
    }

    @Column(name = "OMSCHRIJVING")
    public String getDescription() {
        return description;
    }

    public void setDescription(String omschrijving) {
        this.description = omschrijving;
    }

    @Column(name = "DUUR")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duur) {
        this.duration = duur;
    }

    @Column(name = "PRIJS")
    public int getPrice() {
        return price;
    }

    public void setPrice(int prijs) {
        this.price = prijs;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}
