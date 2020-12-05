package a99fallen.projects.events.domain.repository;

import a99fallen.projects.events.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
