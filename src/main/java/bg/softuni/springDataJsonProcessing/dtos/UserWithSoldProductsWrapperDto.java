package bg.softuni.springDataJsonProcessing.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserWithSoldProductsWrapperDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private ProductWrapperDto soldProducts;

    public UserWithSoldProductsWrapperDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductWrapperDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductWrapperDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
