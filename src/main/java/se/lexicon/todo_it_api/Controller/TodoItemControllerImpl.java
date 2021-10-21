package se.lexicon.todo_it_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.DTO.TodoItemDTO;
import se.lexicon.todo_it_api.form.TodoItemFormDto;
import se.lexicon.todo_it_api.service.PersonService;
import se.lexicon.todo_it_api.service.TodoItemService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("//todo/api/v1/todoItem")
public class TodoItemControllerImpl implements TodoItemController{

    private final TodoItemService todoItemService;
    private final PersonService personService;

    @Autowired
    public TodoItemControllerImpl(TodoItemService todoItemService, PersonService personService) {
        this.todoItemService = todoItemService;
        this.personService = personService;
    }


    private final List<String> searchTypes = Arrays.asList(
            "all", "unassigned", "done_status", "between", "before", "after", "title", "late"
    );

    @Override
    public ResponseEntity<TodoItemDTO> create(TodoItemFormDto itemFormDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(todoItemService.create(itemFormDto));
    }

    @Override
    public ResponseEntity<String> delete(Integer todoItemId) {

        boolean delete = todoItemService.delete(todoItemId);
        return ResponseEntity.ok(delete? "Person was deleted": " Person was not deleted");
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<TodoItemDTO>> find (

                @RequestParam(name = "search", defaultValue = "all") String search,
                @RequestParam(name = "values", defaultValue = "all") String[] values)
        {

            List<TodoItemDTO> todoItemDto;

            switch (search){
                case "all":
                    todoItemDto = todoItemService.findAll();
                    break;
                case "unassigned":
                    todoItemDto = todoItemService.findAllUnassigned();
                    break;
                case "done_status":
                    boolean doneStatus = Boolean.parseBoolean(values[0]);
                    todoItemDto = todoItemService.findByDoneStatus(doneStatus);
                    break;
                case "between":
                    List<LocalDate> dateValues = Stream.of(values)
                            .map(LocalDate::parse)
                            .collect(Collectors.toList());

                    if(dateValues.size() != 2) throw new IllegalArgumentException("Invalid params: expected 2 params. Actual param(s) were " + dateValues);
                    LocalDate start = dateValues.get(0);
                    LocalDate end = dateValues.get(1);
                    todoItemDto = todoItemService.findBetween(start, end);
                    break;
                case "before":
                    LocalDate before = LocalDate.parse(Objects.requireNonNull(values[0]));
                    todoItemDto = todoItemService.findDeadlineBefore(before);
                    break;
                case "after":
                    LocalDate after = LocalDate.parse(Objects.requireNonNull(values[0]));
                    todoItemDto = todoItemService.findDeadlineAfter(after);
                    break;
                case "late":
                    todoItemDto = todoItemService.findAllUnfinishedAndOverdue();
                    break;
                case "title":
                    String title = values[0];
                    todoItemDto = todoItemService.findByTitle(title);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid search type '"+ search+"' valid types are: " + searchTypes);
            }

            return ResponseEntity.ok(todoItemDto);
        }


    @Override
    public ResponseEntity<TodoItemDTO> findById(Integer todoItemId) {

        return ResponseEntity.ok((todoItemService.findById(todoItemId)));
    }

    @Override
    public ResponseEntity<TodoItemDTO> update(Integer todoItemId, TodoItemFormDto TodoItemForm) {


        return ResponseEntity.ok(todoItemService.update(todoItemId,TodoItemForm));
    }
}
