package se.lexicon.todo_it_api.Controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.service.PersonService;
import se.lexicon.todo_it_api.service.TodoItemService;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Locale;

@RestController
@RequestMapping(path = "/todo/api/v1/person")
@CrossOrigin("*")
public class PersonControllerImpl implements PersonController{

    private  final PersonService personService;
    private final TodoItemService todoItemService;

    @Autowired
    public PersonControllerImpl(PersonService personService, TodoItemService todoItemService) {
        this.personService = personService;
        this.todoItemService = todoItemService;
    }

    @Override
    public ResponseEntity<PersonDTO> assignTodoItem(Integer personId, Integer todoItemId) {
        return ResponseEntity.ok(personService.addTodoItem(personId, todoItemId));
    }

    @Override
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonFormDTO personForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personForm));
    }

    @Override
    public ResponseEntity<String> deletePerson(Integer personId) {

        boolean delete = personService.delete(personId);

        return ResponseEntity.ok(delete? "person was deleted": "Person was not deleted");
    }

    @Override
    public ResponseEntity<?> find(String search) {

        switch (search.toLowerCase()){

            case "idle": return findIdlePeople();
            case "all": return findAll();

            default: throw new IllegalArgumentException("Invalid search Param: valid Params Are: all, idle");
        }

    }

    @Override
    public ResponseEntity<Collection<PersonDTO>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @Override
    public ResponseEntity<PersonDTO> findById(Integer personId) {

        return ResponseEntity.ok(personService.findById(personId));

    }

    @Override
    public ResponseEntity<Collection<PersonDTO>> findIdlePeople() {
        return ResponseEntity.ok(personService.findIdlePeople());
    }

    @Override
    public ResponseEntity<Collection<TodoItemDTO>> getTodoItems(Integer personId) {
        return ResponseEntity.ok().body(todoItemService.findAllByPersonId(personId));
    }

    @Override
    public ResponseEntity<PersonDTO> removeTodoItem(Integer personId,  Integer todoItemId) {

        return ResponseEntity.ok(personService.removeTodoItem(personId, todoItemId));
    }

    @Override
    public ResponseEntity<PersonDTO> update(Integer personId, PersonFormDTO personForm) {
        return ResponseEntity.ok(personService.update(personId, personForm));
    }
}
