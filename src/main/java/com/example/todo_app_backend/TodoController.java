package com.example.todo_app_backend;

import org.springframework.http.ResponseEntity; // Add this
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
         return todoService.createTodo(todo);
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Todo> markTodoAsCompleted(@PathVariable Long id) {
        Optional<Todo> optionalTodo = todoService.findTodoById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            // Toggle the completion status
            todo.setCompleted(!todo.isCompleted());
            todoService.save(todo);
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}
