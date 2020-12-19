package a99fallen.projects.events.web.command;

import lombok.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data @Builder @AllArgsConstructor  @RequiredArgsConstructor
public class EditTaskCommand {
//    @NotNull
    @Size(min = 3, max = 64)
    private String name;
//    @NotNull
    @Size(min = 3, max = 160)
    private String description;
    private LocalDate createdOn;
    private LocalDate deadline;
}
