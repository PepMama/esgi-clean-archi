package architecture.clean.java.interfaces.task;

import jakarta.validation.constraints.NotBlank;

public class CreateTaskRequest {

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
