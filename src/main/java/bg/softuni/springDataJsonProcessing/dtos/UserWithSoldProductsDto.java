package bg.softuni.springDataJsonProcessing.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserWithSoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<SoldProductDto> soldProducts;

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

    public List<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

}
