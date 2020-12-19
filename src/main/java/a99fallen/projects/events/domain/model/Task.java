package a99fallen.projects.events.domain.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "users")
@EqualsAndHashCode(of = "id")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(name = "created_on")
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate createdOn;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @ManyToMany (mappedBy = "tasks")
    private Set<User> users = new HashSet();
}