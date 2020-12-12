package a99fallen.projects.events.converter;

import a99fallen.projects.events.domain.model.Task;
import a99fallen.projects.events.web.command.CreateTaskCommand;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    public Task from(CreateTaskCommand command) {
        return Task.builder()
                .name(command.getName())
                .description(command.getDescription())
                .build();
    }
}
