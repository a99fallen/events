package a99fallen.projects.events.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(of = "username")
@ToString(exclude = "password")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "username")
    private String username;
    private String password;
//    private Boolean active = Boolean.FALSE;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "username",
                    referencedColumnName = "username"
            ),
            indexes = @Index(name = "users_roles_username_idx",
                    columnList = "username"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @ManyToMany (mappedBy = "users")
    private List<Task> tasks;

}
