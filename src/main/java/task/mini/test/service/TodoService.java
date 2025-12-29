package task.mini.test.service;

import task.mini.test.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public TodoService() {
        // Données initiales
        todos.add(new Todo(counter.getAndIncrement(), "Apprendre Spring Boot"));
        todos.add(new Todo(counter.getAndIncrement(), "Créer une API REST"));
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    public Todo addTodo(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre est obligatoire");
        }
        
        Todo newTodo = new Todo(counter.getAndIncrement(), title.trim());
        todos.add(newTodo);
        return newTodo;
    }

    public Optional<Todo> updateTodo(Long id, String title, Boolean completed) {
        Optional<Todo> existingTodo = getTodoById(id);
        
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            
            if (title != null && !title.trim().isEmpty()) {
                todo.setTitle(title.trim());
            }
            
            if (completed != null) {
                todo.setCompleted(completed);
            }
            
            return Optional.of(todo);
        }
        
        return Optional.empty();
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }

    public int getTodoCount() {
        return todos.size();
    }
}