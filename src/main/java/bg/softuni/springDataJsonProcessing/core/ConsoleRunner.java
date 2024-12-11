package bg.softuni.springDataJsonProcessing.core;

import bg.softuni.springDataJsonProcessing.dtos.CategoryDto;
import bg.softuni.springDataJsonProcessing.dtos.ProductDto;
import bg.softuni.springDataJsonProcessing.dtos.ProductWithSellerFullNameDto;
import bg.softuni.springDataJsonProcessing.dtos.UserDto;
import bg.softuni.springDataJsonProcessing.services.interfaces.CategoryService;
import bg.softuni.springDataJsonProcessing.services.interfaces.ProductService;
import bg.softuni.springDataJsonProcessing.services.interfaces.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String RESOURCES_JSON_FILES = "src/main/resources/json-files/";
    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private static final String USERS_FILE_NAME = "users.json";
    private static final String PRODUCTS_FILE_NAME = "products.json";
    private final Gson gson;
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ConsoleRunner(Gson gson, BufferedReader bufferedReader, UserService userService, CategoryService categoryService, ProductService productService) {
        this.gson = gson;
        this.bufferedReader = bufferedReader;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedData();
        productsInRange();

    }

    private void productsInRange() throws IOException {
        String priceRange = promptInput("price range in format [low-high]");
        String[] split = priceRange.split("-");

        List<ProductWithSellerFullNameDto> productsInRange;
        try {
            productsInRange = productService
                    .getProductsInRange(new BigDecimal(split[0]), new BigDecimal(split[1]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String json = gson.toJson(productsInRange);

        Files.writeString(Path.of(RESOURCES_JSON_FILES + "products-in-range.json"), json);
    }

    private String promptInput(String message) throws IOException {
        System.out.print("Enter " + message + ":");
        return bufferedReader.readLine();
    }

    private void seedData() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    private void seedProducts() throws IOException {
        String productsJson = parseJsonToString(PRODUCTS_FILE_NAME);

        ProductDto[] productDtos = gson.fromJson(productsJson, ProductDto[].class);

        productService.addAll(productDtos);

    }

    private void seedUsers() throws IOException {
        String usersJson = parseJsonToString(USERS_FILE_NAME);

        UserDto[] userDtos = gson.fromJson(usersJson, UserDto[].class);

        userService.addAll(userDtos);
    }

    private void seedCategories() throws IOException {
        String categoriesJson = parseJsonToString(CATEGORIES_FILE_NAME);

        CategoryDto[] categoryDtos = gson.fromJson(categoriesJson, CategoryDto[].class);

        categoryService.addAll(categoryDtos);
    }

    private static String parseJsonToString(String fileName) throws IOException {
        return Files.readString(Path.of(RESOURCES_JSON_FILES + fileName));
    }

}
