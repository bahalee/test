package task.mini.test.controller;

import task.mini.test.model.Todo;
import task.mini.test.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") 
public class TodoController {
    
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> getTodoCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("count", todoService.getTodoCount());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody Map<String, String> request) {
        try {
            String title = request.get("title");
            Todo newTodo = todoService.addTodo(title);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
        } catch (IllegalArgumentException e) {
            return createErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return createErrorResponse("Erreur serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/object")
    public ResponseEntity<?> addTodoObject(@RequestBody Todo todo) {
        try {
            Todo newTodo = todoService.addTodo(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
        } catch (IllegalArgumentException e) {
            return createErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return createErrorResponse("Erreur serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<Map<String, String>> createErrorResponse(String message, HttpStatus status) {
        Map<String, String> error = new HashMap<>();
        error.put("error", message);
        error.put("status", status.toString());
        return ResponseEntity.status(status).body(error);
    }
}