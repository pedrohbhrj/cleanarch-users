package br.com.pedrohbhrj.crudusers.core.usecases.impl;

import br.com.pedrohbhrj.crudusers.core.domain.User;
import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User createUser(User user) {

        User created = new User();

        created.setId(user.getId());
        created.setCpf(user.getCpf());
        created.setEmail(user.getEmail());
        created.setBirthDayDate(user.getBirthDayDate());
        created.setTelephone(user.getTelephone());
        created.setFirstName(user.getFirstName());
        created.setLastName(user.getLastName());
        created.setId(user.getId());

        return userGateway.save(created);
    }
}
