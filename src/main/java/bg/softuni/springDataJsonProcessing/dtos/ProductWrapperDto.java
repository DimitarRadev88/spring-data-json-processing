package bg.softuni.springDataJsonProcessing.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductWrapperDto {
    @Expose
    private Integer count;
    @Expose
    private List<ProductDto> products;

    public ProductWrapperDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

}
