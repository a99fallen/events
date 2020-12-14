package a99fallen.projects.events.domain.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "created_on")
    @DateTimeFormat (pattern = "yyyy-MM-dd : HH:mm")
    private LocalDateTime createdOn;
    @DateTimeFormat (pattern = "yyyy-MM-dd : HH:mm")
    private LocalDateTime deadline;

    @ManyToMany (mappedBy = "tasks")
    private Set<User> users = new HashSet();
}