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
        return userGateway.save(user);
    }
}
