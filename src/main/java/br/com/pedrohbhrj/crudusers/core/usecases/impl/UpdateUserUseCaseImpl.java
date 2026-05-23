package br.com.pedrohbhrj.crudusers.core.usecases.impl;

import br.com.pedrohbhrj.crudusers.core.domain.User;
import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.UpdateUserUseCase;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGateway userGateway;

    public UpdateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User updateUser(Long id, User user) {
        return userGateway.update(id,user);
    }

}
