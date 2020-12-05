package a99fallen.projects.events.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 45)
    private String name;
    @Column(nullable = false)
    @Size(min = 3, max = 1023)
    private String description;
    private LocalDate createdOn;
    private LocalDate deadline;

    @ManyToOne
    private User user;
    @Column(insertable = false, updatable = false, name = "user_id")
    private Long userId;
}
