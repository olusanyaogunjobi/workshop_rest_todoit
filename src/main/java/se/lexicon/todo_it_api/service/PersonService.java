package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;

import java.util.List;

public interface PersonService {


    //CRUD + Convenience Method
    PersonDTO addTodoItem(Integer personId, Integer todoItemId);
    PersonDTO create (PersonFormDTO personForm);
    Boolean delete (Integer personId);
    List<PersonDTO> findAll();
    PersonDTO findById(Integer personId);
    List<PersonDTO> findIdlePeople();
    PersonDTO removeTodoItem(Integer personId, Integer todoItemId);
    PersonDTO update (Integer personId, PersonFormDTO personForm);




}
