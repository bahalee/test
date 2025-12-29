package task.mini.test.service;

import task.mini.test.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public TodoService() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        addTodo("Apprendre Spring Boot");
        addTodo("Créer une API REST");
        addTodo("Tester avec Postman");
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public Todo addTodo(String title) {
        validateTitle(title);
        
        Todo newTodo = new Todo(counter.getAndIncrement(), title);
        todos.add(newTodo);
        return newTodo;
    }

    public Todo addTodo(Todo todo) {
        validateTitle(todo.getTitle());
        
        if (todo.getId() == null) {
            todo.setId(counter.getAndIncrement());
        }
        todos.add(todo);
        return todo;
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre de la tâche est obligatoire");
        }
    }

    public int getTodoCount() {
        return todos.size();
    }
}
