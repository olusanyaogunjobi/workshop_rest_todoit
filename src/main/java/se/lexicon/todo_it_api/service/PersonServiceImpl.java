package se.lexicon.todo_it_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.data.PersonDAO;
import se.lexicon.todo_it_api.data.TodoItemDAO;
import se.lexicon.todo_it_api.exception.AppResourceNotFoundException;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.model.entity.Person;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;
    private final TodoItemDAO todoItemDAO;
    private final ConversionService conversionService;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO, TodoItemDAO todoItemDAO, ConversionService conversionService) {
        this.personDAO = personDAO;
        this.todoItemDAO = todoItemDAO;
        this.conversionService = conversionService;
    }


    @Override
    public PersonDTO addTodoItem(Integer personId, Integer todoItemId) {

        Optional<Person> person = personDAO.findById(personId);
        Optional<TodoItem> todoItem = todoItemDAO.findById(todoItemId);

        if (person.isPresent() & person.isPresent()) {
            person.get().addTodoItem(todoItem.get());
        }
        return conversionService.toPersonDto(person.get());
    }

    @Override
    public PersonDTO create(PersonFormDTO personForm) {

        Person saved = personDAO.save(conversionService.toPerson(personForm));

        return conversionService.toPersonDto(saved);
    }

    @Override
    public Boolean delete(Integer personId) {

        personDAO.deleteById(personId);
        return !personDAO.existsById(personId);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> peopleFound = (List<Person>) personDAO.findAll();

        List<PersonDTO> peopleDtoList = new ArrayList<>();

        peopleFound.forEach( (person) -> peopleDtoList.add(conversionService.toPersonDto(person)) );

        return peopleDtoList;

    }

    @Override
    public PersonDTO findById(Integer personId) {

        Optional<Person> foundById = personDAO.findById(personId);
        Person person = foundById.orElseThrow(()-> new AppResourceNotFoundException("Could not find Person By Id" + personId));
        return conversionService.toPersonDto(person);
    }


    @Override
    public List<PersonDTO> findIdlePeople() {

        List<Person> idlePeople = personDAO.findIdlePeople();
        List<PersonDTO> peopleDtoList = new ArrayList<>();

        idlePeople.forEach(
                (person) -> peopleDtoList.add(conversionService.toPersonDto(person))
        );

        return peopleDtoList;
    }

    @Override
    public PersonDTO removeTodoItem(Integer personId, Integer todoItemId) {

        Person person = personDAO.findById(personId).orElseThrow( () -> new AppResourceNotFoundException("person Not found"));
        TodoItem todoItem = todoItemDAO.findById(todoItemId).orElseThrow( () -> new AppResourceNotFoundException("TodoItem Not found"));

        person.removeTodoItem(todoItem);

        return conversionService.toPersonDto(person);

    }

    @Override
    public PersonDTO update(Integer personId, PersonFormDTO personForm) {

        Optional<Person> foundPerson = personDAO.findById(personId);
        if (foundPerson.isPresent()) {
            foundPerson.get().setFirstName(personForm.getFirstName());
            foundPerson.get().setLastName(personForm.getLastName());
            foundPerson.get().setBirthDate(personForm.getBirthDate());

        }
        if (foundPerson.isPresent()) {

            return conversionService.toPersonDto(foundPerson.get());
        } else {
            throw new IllegalArgumentException("Could not find By Id");
        }

    }
}