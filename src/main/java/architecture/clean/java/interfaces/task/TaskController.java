package architecture.clean.java.interfaces.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import architecture.clean.java.usecases.task.CreateTaskUseCase;
import architecture.clean.java.usecases.task.LoadTasksUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final LoadTasksUseCase loadTasksUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, LoadTasksUseCase loadTasksUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.loadTasksUseCase = loadTasksUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@Valid @RequestBody CreateTaskRequest request) {
        return new TaskResponse(createTaskUseCase.create(request.getTitle()));
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return loadTasksUseCase.loadAll()
                .stream()
                .map(TaskResponse::new)
                .toList();
    }
}
