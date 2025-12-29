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
        initializeSampleData();
    }

    private void initializeSampleData() {
        addTodo("Apprendre Spring Boot");
        addTodo("Créer une API REST");
        addTodo("Tester avec Postman");
        addTodo("Ajouter les opérations CRUD");
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
        validateTitle(title);
        
        Todo newTodo = new Todo(counter.getAndIncrement(), title.trim());
        todos.add(newTodo);
        return newTodo;
    }

    // Surcharge pour accepter un objet Todo
    public Todo addTodo(Todo todo) {
        validateTitle(todo.getTitle());
        
        if (todo.getId() == null) {
            todo.setId(counter.getAndIncrement());
        }
        todos.add(todo);
        return todo;
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

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre de la tâche est obligatoire");
        }
    }
}