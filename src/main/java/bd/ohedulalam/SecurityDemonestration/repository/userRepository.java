package bd.ohedulalam.SecurityDemonestration.repository;

import bd.ohedulalam.SecurityDemonestration.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<users, Integer> {
    Optional<users> findByName(String name);


}
