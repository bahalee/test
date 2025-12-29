package task.mini.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private boolean completed = false;

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}