package architecture.clean.java.usecases.task;

import java.util.List;

import architecture.clean.java.entities.task.Task;

public interface LoadTasksUseCase {
    List<Task> loadAll();
}
