package br.com.pedrohbhrj.crudusers.core.usecases.impl;

import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.DeleteUserByIdUseCase;
import jakarta.persistence.EntityNotFoundException;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {

    private final UserGateway userGateway;

    public DeleteUserByIdUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void deleteUserById(Long id) {

        if(!userGateway.existsById(id)){
            throw new EntityNotFoundException("Entity not found.");
        }

        userGateway.deleteById(id);

    }
}
