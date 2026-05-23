package br.com.pedrohbhrj.crudusers.core.usecases.interf;

import br.com.pedrohbhrj.crudusers.core.domain.User;


public interface FindUserByIdUseCase {
    User findUserById(Long id);
}
