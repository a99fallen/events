package a99fallen.projects.events.domain.repository;

import a99fallen.projects.events.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
