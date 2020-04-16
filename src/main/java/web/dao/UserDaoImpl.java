package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listOfUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User ").getResultList();
    }

    @Override
    public void addUser(String firstName, String lastName){
        sessionFactory.getCurrentSession().save(new User(firstName, lastName));
    }

    @Override
    public void deleteUser(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE User u WHERE u.id = ?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public void editUser(Long id, String newFirstName, String newLastName){
        Query query = sessionFactory.getCurrentSession().createQuery("UPDATE User set firstName = ?1, lastName = ?2 WHERE id = ?3");
        query.setParameter(1, newFirstName);
        query.setParameter(2, newLastName);
        query.setParameter(3, id);
        query.executeUpdate();
    }


}
