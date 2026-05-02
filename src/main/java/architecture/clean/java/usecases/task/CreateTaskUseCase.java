package architecture.clean.java.usecases.task;

import architecture.clean.java.entities.task.Task;

public interface CreateTaskUseCase {
    Task create(String title);
}
