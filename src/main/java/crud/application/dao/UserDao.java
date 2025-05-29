package crud.application.dao;

import crud.application.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    User findOne(int id);
    List<User> findAll();
    void update(User user);
    void delete(int id);

}
