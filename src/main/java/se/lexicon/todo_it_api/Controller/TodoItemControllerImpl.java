package se.lexicon.todo_it_api.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.TodoItemFormDto;

import java.util.Collection;

@RestController
@RequestMapping("/todoItem")
public class TodoItemControllerImpl implements TodoItemController{
    @Override
    public ResponseEntity<TodoItemDTO> create(TodoItemFormDto itemFormDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<TodoItemDTO>> find(String[] String) {
        return null;
    }

    @Override
    public ResponseEntity<TodoItemDTO> findById(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<TodoItemDTO> update(Integer todoItemId, TodoItemFormDto TodoItemForm) {
        return null;
    }
}
