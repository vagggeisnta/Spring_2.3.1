package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> listOfUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void editUser(Long id, User user);
}
