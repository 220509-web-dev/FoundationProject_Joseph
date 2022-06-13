package dev.joe.models;

import java.util.Objects;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User() { super();}
    public User(int id) {
        super();
        this.id = id;
    }

    public User(String firstname, String lastname, String username, String password) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(int id, String firstname, String lastname, String username, String password) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstname() {return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() {return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname)
                && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() { return Objects.hash(id, firstname, lastname, username, password); }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}' + "\n";
    }
}
