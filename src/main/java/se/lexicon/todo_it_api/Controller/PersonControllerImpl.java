package se.lexicon.todo_it_api.Controller;

import org.springframework.http.ResponseEntity;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;

import java.util.Collection;

public class PersonControllerImpl implements PersonController{
    @Override
    public ResponseEntity<PersonDTO> assignTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<PersonDTO> create(PersonFormDTO personForm) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePerson(String personId) {
        return null;
    }

    @Override
    public ResponseEntity<?> find(String personId) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<PersonDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PersonDTO> findById(Integer personId) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<PersonDTO>> findIdlePeople() {
        return null;
    }

    @Override
    public ResponseEntity<Collection<TodoItemDTO>> getTodoItems(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<PersonDTO> removeTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<PersonDTO> update(Integer personId, PersonFormDTO personForm) {
        return null;
    }
}
