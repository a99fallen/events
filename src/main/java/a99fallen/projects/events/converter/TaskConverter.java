package a99fallen.projects.events.converter;

import a99fallen.projects.events.data.task.TaskSummary;
import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import a99fallen.projects.events.web.command.EditTaskCommand;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class TaskConverter {

    public Task from(CreateTaskCommand command) {
        return Task.builder()
                .name(command.getName())
                .description(command.getDescription())
                .createdOn(LocalDate.now())
                .deadline(command.getDeadline())
                .build();
    }

    public TaskSummary toTaskSummary(Task task) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return TaskSummary.builder()
                .name(task.getName())
                .description(task.getDescription())
                .createdOn(task.getCreatedOn())
                .deadline(task.getDeadline())
                .username(username)
                .build();
    }


    public EditTaskCommand editTaskCommand(Task task) {
        return EditTaskCommand.builder()
                .name(task.getName().trim())
                .description(task.getDescription().trim())
                .createdOn(task.getCreatedOn())
                .deadline(task.getDeadline())
                .build();
    }

    public Task editTaskFromCommand(EditTaskCommand editTaskCommand, Task task){
        task.setName(editTaskCommand.getName().trim());
        task.setDescription(editTaskCommand.getDescription().trim());
        task.setCreatedOn(editTaskCommand.getCreatedOn());
        task.setDeadline(editTaskCommand.getDeadline());
        return  task;
    }
}
