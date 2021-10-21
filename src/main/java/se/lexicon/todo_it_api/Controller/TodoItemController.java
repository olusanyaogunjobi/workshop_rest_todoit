package se.lexicon.todo_it_api.Controller;

import io.swagger.models.auth.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.TodoItemFormDto;

import java.net.ServerSocket;
import java.util.Collection;

public interface TodoItemController {

    @PostMapping("/todo/api/v1/todoItem/itemForm/")
    ResponseEntity<TodoItemDTO> create(TodoItemFormDto itemFormDto);

    @DeleteMapping("/todo/api/v1/todoItem/{Id}")
    ResponseEntity<String> delete(@PathVariable("Id")Integer todoItemId);

    @GetMapping("/todo/api/v1/todoItem/")
    ResponseEntity<Collection<TodoItemDTO>> find( String search, String[] values);

    @GetMapping("/todo/api/v1/todoItem/{Id}")
    ResponseEntity<TodoItemDTO> findById(@PathVariable("Id") Integer todoItemId);

    @PutMapping("/todo/api/v1/todoItem/{}")
    ResponseEntity<TodoItemDTO> update(Integer todoItemId,TodoItemFormDto TodoItemForm);

}
