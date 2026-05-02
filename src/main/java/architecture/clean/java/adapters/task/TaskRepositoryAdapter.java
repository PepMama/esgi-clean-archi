package architecture.clean.java.adapters.task;

import java.util.List;

import org.springframework.stereotype.Repository;

import architecture.clean.java.entities.task.Task;
import architecture.clean.java.usecases.task.TaskRepositoryPort;

@Repository
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskJpaRepository jpaRepository;

    public TaskRepositoryAdapter(TaskJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        TaskJpaEntity entity = toEntity(task);
        TaskJpaEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    // Convertit un objet domaine en entité JPA
    private TaskJpaEntity toEntity(Task task) {
        TaskJpaEntity entity = new TaskJpaEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setCompleted(task.isCompleted());
        return entity;
    }

    // Convertit une entité JPA en objet domaine
    private Task toDomain(TaskJpaEntity entity) {
        Task task = new Task(entity.getId(), entity.getTitle());
        if (entity.isCompleted()) {
            task.complete();
        }
        return task;
    }
}
