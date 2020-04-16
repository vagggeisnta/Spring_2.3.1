package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
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
    public void addUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE User u WHERE u.id = ?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public void editUser(Long id, User user){
        Session session = sessionFactory.getCurrentSession();
        User oldUser = session.get(User.class, id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        session.update(oldUser);
    }
}
