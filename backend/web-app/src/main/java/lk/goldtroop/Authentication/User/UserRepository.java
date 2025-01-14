package lk.goldtroop.Authentication.User;

//import com.example.buildermatebackend.Entity.OutputUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByUserID(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    User findByResetPasswordToken(String token);
    List<User> findUsersByActivatedEquals(int active);


    List<User> findUsersByUserRole(UserRole role);


}
