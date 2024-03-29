package users;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String password;

    public User(){

    }

    public User(String firstName, String lastName, int age, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, password);
    }

    @Override
    public String toString() {
        return "User: " +
                "id = " + id +
                ", firstName = " + firstName + '\'' +
                ", lastName = " + lastName + '\'' +
                ", age = " + age +
                ", password = " + password + '\'';
    }
}