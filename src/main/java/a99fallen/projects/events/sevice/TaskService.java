package a99fallen.projects.events.sevice;

<<<<<<< HEAD
import a99fallen.projects.events.converter.TaskConverter;
import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.domain.repository.TaskRepository;
import a99fallen.projects.events.domain.repository.UserRepository;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskConverter taskConverter;

    public void add(CreateTaskCommand createTaskCommand) {
        log.debug("Dane do utworzenia zadania: {}", createTaskCommand);

        Task task = taskConverter.from(createTaskCommand);
        updateTaskWithUser(task);
        log.debug("Zadanie do zapisu: {}", task);

        taskRepository.save(task);
        log.debug("Zapisane zadanie: {}", task);
    }

    private void updateTaskWithUser(Task task) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getAuthenticatedUser(username);
        task.setUsers((Set<User>) user);
    }
}