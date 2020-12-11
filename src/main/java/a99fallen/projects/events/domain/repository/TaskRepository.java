package a99fallen.projects.events.domain.repository;

import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUsersUsername(User username);

    Optional<Task> findByName(String sourceName);
}
