package a99fallen.projects.events.sevice;

import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
