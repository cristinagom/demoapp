package demoapp.repository;

import demoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNombreIgnoreCase(String nombre);
    List<User> findAllByOrderByNombreDesc();
}
