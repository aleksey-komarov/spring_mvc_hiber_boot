package ru.komarov.springmvchiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.komarov.springmvchiber.model.User;
import ru.komarov.springmvchiber.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        Optional<User> findUser = userRepository.findById(id);
        return findUser.orElse(null);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
