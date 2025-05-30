package crud.application.service;

import crud.application.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findOne(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
