package se.lexicon.todo_it_api.form;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Objects;

public class PersonFormDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public PersonFormDTO(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public PersonFormDTO() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonFormDTO)) return false;
        PersonFormDTO that = (PersonFormDTO) o;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getBirthDate().equals(that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getBirthDate());
    }

    @Override
    public String toString() {
        return "PersonFormDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
