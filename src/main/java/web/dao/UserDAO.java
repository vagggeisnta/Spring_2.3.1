package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> listOfUsers();

    void addUser(String firstName, String lastName);

    void deleteUser(Long id);

    void editUser(Long id, String newFirstName, String newLastName);
}
