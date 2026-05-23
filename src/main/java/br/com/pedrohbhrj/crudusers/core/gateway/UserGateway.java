package br.com.pedrohbhrj.crudusers.core.gateway;

import br.com.pedrohbhrj.crudusers.core.domain.User;
import java.util.List;

public interface UserGateway{
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
    User update(Long id,User user);
}
