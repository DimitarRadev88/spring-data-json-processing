package bg.softuni.springDataJsonProcessing.repositories;

import bg.softuni.springDataJsonProcessing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            FROM User u
            JOIN FETCH u.soldProducts sold
            WHERE sold.buyer IS NOT NULL
            ORDER BY u.firstName, u.lastName
            """)
    List<User> findAllBySoldProductsBuyerNotEmpty();

}
