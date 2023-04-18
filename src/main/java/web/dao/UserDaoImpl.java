package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;
import web.models.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao{
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User("Аня", 35));
        users.add(new User("Амина", 27));
        users.add(new User("Лариса", 23));
        users.add(new User("Саша", 36));
        users.add(new User("Никита", 21));

    }
    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(long id) {
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    @Override
    public void cleanUsersTable() {

    }
}
