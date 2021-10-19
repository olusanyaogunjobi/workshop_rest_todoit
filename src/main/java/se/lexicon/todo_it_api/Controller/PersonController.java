package se.lexicon.todo_it_api.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.model.entity.Person;

import java.util.Collection;


public interface PersonController {

    ResponseEntity <PersonDTO> assignTodoItem (Integer personId, Integer todoItemId);
    ResponseEntity <PersonDTO> create (PersonFormDTO personForm);
    ResponseEntity<String> deletePerson(String personId);
    ResponseEntity<?> find(String personId);
    ResponseEntity<Collection<PersonDTO>> findAll();
    ResponseEntity<PersonDTO>findById(Integer personId);
    ResponseEntity<Collection<PersonDTO>> findIdlePeople();
    ResponseEntity<Collection<TodoItemDTO>> getTodoItems(Integer todoItemId);
    ResponseEntity<PersonDTO> removeTodoItem(Integer personId, Integer todoItemId);
    ResponseEntity<PersonDTO> update (Integer personId, PersonFormDTO personForm);



}
