package bg.softuni.springDataJsonProcessing.dtos;

import java.util.List;

public class UserWithSoldProductsWrapperDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private List<ProductWrapperDto> soldProducts;
}
