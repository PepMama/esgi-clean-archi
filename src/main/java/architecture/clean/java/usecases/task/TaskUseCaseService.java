package architecture.clean.java.usecases.task;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import architecture.clean.java.entities.task.Task;

@Service
public class TaskUseCaseService implements CreateTaskUseCase, LoadTasksUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public TaskUseCaseService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task create(String title) {
        String id = UUID.randomUUID().toString();
        Task task = new Task(id, title);
        return taskRepositoryPort.save(task);
    }

    @Override
    public List<Task> loadAll() {
        return taskRepositoryPort.findAll();
    }
}
