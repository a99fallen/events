package a99fallen.projects.events.sevice;

import a99fallen.projects.events.converter.TaskConverter;
import a99fallen.projects.events.data.task.TaskSummary;
import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.domain.model.User;
import a99fallen.projects.events.domain.repository.TaskRepository;
import a99fallen.projects.events.domain.repository.UserRepository;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskConverter taskConverter;

    @Transactional
    public void add(CreateTaskCommand createTaskCommand) {
        log.debug("Dane do utworzenia zadania: {}", createTaskCommand);

        Task task = taskConverter.from(createTaskCommand);
        updateTaskWithUser(task);
        log.debug("Zadanie do zapisu: {}", task);

        taskRepository.save(task);
        log.debug("Zapisane zadanie: {}", task);
    }

    @Transactional
    public List<TaskSummary> findUserTasks() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getAuthenticatedUser(username);
        return taskRepository.findAllByUsersUsername(user).stream()
                .map(taskConverter::toTaskSummary)
                .collect(Collectors.toList());
    }

    private void updateTaskWithUser(Task task) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getAuthenticatedUser(username);
        task.setUsers(new HashSet<>());
        Set<User> users = task.getUsers();
        users.add(user);
    }
}