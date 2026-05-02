package architecture.clean.java.interfaces.task;

import architecture.clean.java.entities.task.Task;

public class TaskResponse {

    private final String id;
    private final String title;
    private final boolean completed;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.completed = task.isCompleted();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
}
