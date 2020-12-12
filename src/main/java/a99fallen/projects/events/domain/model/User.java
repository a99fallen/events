package a99fallen.projects.events.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(of = "username")
@ToString(exclude = "password")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
//    private Boolean active = Boolean.FALSE;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "username",
                    referencedColumnName = "username"),
            indexes = @Index(
                    name = "user_roles_username_idx",
                    columnList = "username"))
    @Column(name = "role")
    private Set<String> roles;

    @ManyToMany
    @JoinTable(
            name = "user_tasks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks = new ArrayList<>();
}