package br.com.pedrohbhrj.crudusers.core.usecases.impl;

import br.com.pedrohbhrj.crudusers.core.domain.User;
import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.FindAllUsersUseCase;

import java.util.List;

public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase {

    private final UserGateway userGateway;

    public FindAllUsersUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> findAllUsers() {
        return userGateway.findAll();
    }
}
