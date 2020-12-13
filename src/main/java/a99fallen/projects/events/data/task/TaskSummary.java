package a99fallen.projects.events.data.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class TaskSummary {

    private String name;
    private String description;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate createdOn;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private String username;
}
