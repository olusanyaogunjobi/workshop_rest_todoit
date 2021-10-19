package se.lexicon.todo_it_api.DTO;

import java.time.LocalDate;

public class TodoItemDTOSmall {

    private Integer Id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;


    public TodoItemDTOSmall() {
    }

    public TodoItemDTOSmall(Integer id, String title, String description, LocalDate deadLine, boolean done) {
        Id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

}
