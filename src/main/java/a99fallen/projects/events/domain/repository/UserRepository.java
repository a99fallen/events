package a99fallen.projects.events.domain.repository;

import a99fallen.projects.events.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    default String getUserByAnyUsername() {
        return "andrzej";
    }

    Boolean existsUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getAuthenticatedUser(String username);
}
