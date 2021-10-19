package se.lexicon.todo_it_api.DTO;

import se.lexicon.todo_it_api.model.entity.TodoItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PersonDTO<TodoItemDto> {

    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<TodoItemDTO> todoItems;

    public PersonDTO() {
    }

    public PersonDTO(Integer personId, String firstName, String lastName, LocalDate birthDate, List<TodoItemDTO> todoItems) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.todoItems = todoItems;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<TodoItemDTO> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItemDTO> todoItems) {
        this.todoItems = todoItems;
    }
}
