package se.lexicon.todo_it_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.data.PersonDAO;
import se.lexicon.todo_it_api.data.TodoItemDAO;
import se.lexicon.todo_it_api.exception.AppResourceNotFoundException;
import se.lexicon.todo_it_api.form.TodoItemFormDto;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    private final PersonDAO personDAO;
    private final TodoItemDAO todoItemDAO;
    private final ConversionService conversionService;

    @Autowired
    public TodoItemServiceImpl(PersonDAO personDAO, TodoItemDAO todoItemDAO, ConversionService conversionService) {
        this.personDAO = personDAO;
        this.todoItemDAO = todoItemDAO;
        this.conversionService = conversionService;
    }

    @Override
    public TodoItemDTO create(TodoItemFormDto TodoItemForm) {

        TodoItem Saved = todoItemDAO.save(conversionService.toTodoItem(TodoItemForm));

        return conversionService.toTodoItemDTO(Saved);
    }

    @Override
    public Boolean delete(Integer todoId) {

        todoItemDAO.deleteById(todoId);
        return !todoItemDAO.existsById(todoId);

    }

    @Override
    public List<TodoItemDTO> findAll() {

        List<TodoItem> todoItemFound = (List<TodoItem>) todoItemDAO.findAll();
        List<TodoItemDTO> todoItemDTOList = new ArrayList<>();
        todoItemFound.forEach(todoItem -> todoItemDTOList.add(conversionService.toTodoItemDTO(todoItem)));


        return todoItemDTOList;
    }

    @Override
    public List<TodoItemDTO> findAllByPersonId(Integer personId) {



        return null;
    }

    @Override
    public List<TodoItemDTO> findAllUnassigned() {
        return null;
    }

    @Override
    public List<TodoItemDTO> findAllUnfinishedAndOverdue() {
        return null;
    }

    @Override
    public List<TodoItemDTO> findDeadlineAfter(LocalDate deadline) {
        return null;
    }

    @Override
    public List<TodoItemDTO> findDeadlineBefore(LocalDate deadline) {
        return null;
    }

    @Override
    public List<TodoItemDTO> findBetween(LocalDate localDate) {
        return null;
    }

    @Override
    public List<TodoItemDTO> findByDoneStatus(Boolean isDone) {
        return null;
    }

    @Override
    public TodoItemDTO findById(Integer todoId) {

        Optional<TodoItem> foundById = todoItemDAO.findById(todoId);
        TodoItem todoItem = foundById.orElseThrow(()-> new AppResourceNotFoundException("Could not find any item todo"));
        return conversionService.toTodoItemDTO(todoItem);

    }

    @Override
    public List<TodoItemDTO> findByTitle(String title) {

        /*return todoItemDAO.findByTitleContains(title).stream()
                .map()
                .collect(Collectors.toList())*/
return null;
    }

    @Override
    @Transactional
    public TodoItemDTO update(Integer todoItemId, TodoItemFormDto TodoItemForm) {
        Optional<TodoItem> foundTodoItem = todoItemDAO.findById(todoItemId);

        if (foundTodoItem.isPresent()){
            foundTodoItem.get().setTitle(TodoItemForm.getTitle());
            foundTodoItem.get().setDescription(TodoItemForm.getDescription());
            foundTodoItem.get().setDeadLine(TodoItemForm.getDeadLine());
            foundTodoItem.get().setDone(TodoItemForm.isDone());

        }
        if (foundTodoItem.isPresent()){

            return conversionService.toTodoItemDTO(foundTodoItem.get());
        }else {
            throw new IllegalArgumentException("Could not find By Id");
        }

    }
}
