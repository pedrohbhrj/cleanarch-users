package br.com.pedrohbhrj.crudusers.infra.gateway;


import br.com.pedrohbhrj.crudusers.core.domain.User;
import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.infra.entity.UserEntity;
import br.com.pedrohbhrj.crudusers.infra.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public User save(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setCpf(user.getCpf());
        userEntity.setTelephone(user.getTelephone());
        userEntity.setBirthDayDate(user.getBirthDayDate());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userRepository.save(userEntity);

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities
                .stream().map(u -> new User(
                        u.getId(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getCpf(),
                        u.getBirthDayDate(),
                        u.getTelephone()
                ))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found."));

        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getCpf(),
                userEntity.getBirthDayDate(),
                userEntity.getTelephone()
        );
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found.");
        }
        userRepository.deleteById(id);
    }
}
