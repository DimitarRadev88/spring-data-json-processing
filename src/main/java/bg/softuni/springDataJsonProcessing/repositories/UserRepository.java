package bg.softuni.springDataJsonProcessing.repositories;

import bg.softuni.springDataJsonProcessing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
