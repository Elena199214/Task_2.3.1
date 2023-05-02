package web.dao;


import org.springframework.stereotype.Repository;

import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void removeUserById(long id) {
        if (getUserById(id) != null) {
            entityManager.remove(getUserById(id));
        }
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update( User updaeteUser) {
        if (getUserById(updaeteUser.getId()) != null) {
            entityManager.merge(updaeteUser);
        }
    }
}
