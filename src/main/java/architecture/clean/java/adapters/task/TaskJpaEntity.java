package architecture.clean.java.adapters.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
public class TaskJpaEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    private boolean completed;
}
