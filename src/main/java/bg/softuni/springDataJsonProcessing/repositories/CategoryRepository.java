package bg.softuni.springDataJsonProcessing.repositories;

import bg.softuni.springDataJsonProcessing.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
