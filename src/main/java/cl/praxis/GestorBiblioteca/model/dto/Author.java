package cl.praxis.GestorBiblioteca.model.dto;

public class Author {

    private int id;
    private String name;
    private String lastName;
    private int yearOfBirth;

    public Author() {
    }

    public Author(int id, String name, String lastName, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
