package a99fallen.projects.events.data.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.LocalDateParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class TaskSummary {

    private String name;
    private String description;
    @DateTimeFormat (pattern = "yyyy-MM-dd : HH:mm")
    private LocalDateTime createdOn;
    @DateTimeFormat (pattern = "yyyy-MM-dd : HH:mm")
    private LocalDateTime deadline;
    private String username;


    public String getFormattedDateCreatedOn() {
        return createdOn.format(DateTimeFormatter.ofPattern("yyyy-MM-dd : HH:mm"));
    }

    public String getFormattedDaeDeadline() {
        return createdOn.format(DateTimeFormatter.ofPattern("yyyy-MM-dd : HH:mm"));
    }
}
