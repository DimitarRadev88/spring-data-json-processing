package bg.softuni.springDataJsonProcessing.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String name;
    private List<Product> products;

    public Category() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
