package se.lexicon.todo_it_api.DTO;

import java.time.LocalDate;

public class TodoItemDTO {

    private Integer todoId;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private PersonDTOSmall assignee;

    public TodoItemDTO() {
    }

    public TodoItemDTO(Integer todoId, String title, String description, LocalDate deadLine, boolean done, PersonDTOSmall assignee) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.assignee = assignee;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public PersonDTOSmall getAssignee() {
        return assignee;
    }

    public void setAssignee(PersonDTOSmall assignee) {
        this.assignee = assignee;
    }
}
