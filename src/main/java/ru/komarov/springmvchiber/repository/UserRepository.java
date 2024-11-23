package ru.komarov.springmvchiber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komarov.springmvchiber.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}