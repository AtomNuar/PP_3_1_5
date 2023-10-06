package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


@Service
@Transactional
public interface UserService extends UserDetailsService {

    public User getUserByEmail(String email);

    public User getUserById(long id);

    public List<User> getAllUsers();

    public void save(User user);

    public void update(Long id, User user);

    public void delete(long id);

    public void setInitData();
}
