package se.lexicon.todo_it_api.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.model.entity.Person;

import javax.validation.Valid;
import java.util.Collection;


public interface PersonController {
    @PutMapping("/{Id}/todos/add")
    ResponseEntity <PersonDTO> assignTodoItem (@PathVariable("Id") Integer personId, @RequestParam("todoItemId") Integer todoItemId);

    @PostMapping
    ResponseEntity <PersonDTO> create (PersonFormDTO personForm);

    @DeleteMapping(path = "/{Id}")
    ResponseEntity<String> deletePerson(@PathVariable("Id") Integer personId);

    @GetMapping
    ResponseEntity<?> find(@RequestParam(value = "search", defaultValue = "all") String search);


    ResponseEntity<Collection<PersonDTO>> findAll();

    @GetMapping("/{Id}")
    ResponseEntity<PersonDTO>findById( @PathVariable("Id") Integer personId);

    ResponseEntity<Collection<PersonDTO>> findIdlePeople();

    @GetMapping("/{Id}/todos")
    ResponseEntity<Collection<TodoItemDTO>> getTodoItems(@PathVariable("Id") Integer personId);

    @DeleteMapping("/{Id}/todo/remove")
    ResponseEntity<PersonDTO> removeTodoItem(@PathVariable("Id") Integer personId,@RequestParam("todoItemId")  Integer todoItemId);

    @PutMapping("/{Id}")
    ResponseEntity<PersonDTO> update (@PathVariable("Id") Integer personId, @RequestBody @Valid PersonFormDTO personForm);



}
