package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void createUserTable() {
        String createUserTableSQL = """
                CREATE TABLE IF NOT EXISTS users (
                id SERIAL PRiMARY KEY,
                name VARCHAR(20) NOT NULL,
                surname VARCHAR(20) NOT NULL,
                age SMALLINT NOT NULL)""";

        entityManager.createNativeQuery(createUserTableSQL).executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void updateUser(long id, User createUser) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(createUser.getName());
            user.setSurname(createUser.getSurname());
            user.setAge(createUser.getAge());
        }
    }
}
