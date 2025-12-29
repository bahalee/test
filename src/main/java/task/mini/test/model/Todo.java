package task.mini.test.model;

public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public Todo() {
        this.completed = false;
    }

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public Todo(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}