package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> listOfUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void editUser(Long id, User user);
}
