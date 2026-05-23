package br.com.pedrohbhrj.crudusers.core.gateway;

import br.com.pedrohbhrj.crudusers.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
