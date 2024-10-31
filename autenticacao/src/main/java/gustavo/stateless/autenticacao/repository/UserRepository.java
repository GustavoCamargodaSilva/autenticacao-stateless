package gustavo.stateless.autenticacao.repository;

import gustavo.stateless.autenticacao.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

}