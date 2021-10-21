package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.DTO.PersonDTO;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.PersonFormDTO;
import se.lexicon.todo_it_api.form.TodoItemFormDto;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemService {

    TodoItemDTO create (TodoItemFormDto TodoItemForm);
    Boolean delete (Integer todoId);
    List<TodoItemDTO> findAll();
    List<TodoItemDTO> findAllByPersonId(Integer personId);
    List<TodoItemDTO> findAllUnassigned();
    List<TodoItemDTO> findAllUnfinishedAndOverdue();
    List<TodoItemDTO> findDeadlineAfter(LocalDate deadline);
    List<TodoItemDTO> findDeadlineBefore(LocalDate deadline);
    List<TodoItemDTO> findBetween(LocalDate start, LocalDate end);
    List<TodoItemDTO> findByDoneStatus(Boolean isDone);
    TodoItemDTO findById(Integer todoId);
    List<TodoItemDTO> findByTitle(String title);
    TodoItemDTO update (Integer todoItemId,TodoItemFormDto TodoItemForm);




}
