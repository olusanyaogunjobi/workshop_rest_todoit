package se.lexicon.todo_it_api.service;

import org.springframework.stereotype.Component;
import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.PersonDTOSmall;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTOSmall;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.form.TodoItemFormDto;
import se.lexicon.todo_it_api.model.entity.Person;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConversionService {

    public Person toPerson(PersonFormDTO form){

        return new Person(form.getFirstName(), form.getLastName(), form.getBirthDate(), new ArrayList<>());
    }

    public PersonDTO toPersonDto(Person person){

        List<TodoItemDTOSmall> list = new ArrayList<>();

        for (TodoItem item: person.getTodoItems()){
            list.add(new TodoItemDTOSmall(item.getTodoId(),item.getTitle(),item.getDescription(),item.getDeadLine(),item.isDone()));
        }

        PersonDTO personDTO = new PersonDTO(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getBirthDate(),list);
        return personDTO;
    }

    public TodoItem toTodoItem(TodoItemFormDto formDto){

      return new TodoItem(0, formDto.getTitle(), formDto.getDescription(), formDto.getDeadLine(), formDto.isDone(), null) ;


    }

    public TodoItemDTO toTodoItemDTO( TodoItem todoItem){

        Person person = todoItem.getAssignee();
        PersonDTOSmall personDTOSmall = new PersonDTOSmall(person.getPersonId(),person.getFirstName(), person.getLastName(), person.getBirthDate());

        TodoItemDTO todoItemDTO = new TodoItemDTO(todoItem.getTodoId(), todoItem.getTitle(), todoItem.getDescription(), todoItem.getDeadLine(), todoItem.isDone(), personDTOSmall);

        return todoItemDTO;

    }
}