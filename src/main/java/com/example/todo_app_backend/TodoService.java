package com.example.todo_app_backend;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Add this method to find a Todo by ID
    public Optional<Todo> findTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
}
