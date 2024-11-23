package ru.komarov.springmvchiber.service;

import ru.komarov.springmvchiber.model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<User> listUsers();
    User getUser (long id);
    void updateUser (long id, User user);
    void deleteUser(long id);

}
