package architecture.clean.java.entities.task;

public class Task {

    private String id;
    private String title;
    private boolean completed;

    public Task(String id, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    public void complete() {
        this.completed = true;
    }
}
