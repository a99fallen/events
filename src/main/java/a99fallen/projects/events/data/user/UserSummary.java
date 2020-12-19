package a99fallen.projects.events.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserSummary {

    private String username;
    private String firstName;
    private String lastName;
    @DateTimeFormat (pattern = "yyyy-MM-dd : HH:mm")
    @Column(name = "created_on")
    private LocalDateTime createdOn;
}
