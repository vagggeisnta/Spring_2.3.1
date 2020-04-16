package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public List<User> listOfUsers() {
        return userDAO.listOfUsers();
    }

    @Transactional
    @Override
    public void addUser(String firstName, String lastName) {
        userDAO.addUser(firstName, lastName);
    }

    @Transactional
    @Override
    public void deleteUser(Long id){
        userDAO.deleteUser(id);

    }

    @Transactional
    @Override
    public void editUser(Long id, String newFirstName, String newLastName){
        userDAO.editUser(id, newFirstName, newLastName);
    }
}
