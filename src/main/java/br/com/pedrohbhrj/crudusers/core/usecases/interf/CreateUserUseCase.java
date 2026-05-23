package br.com.pedrohbhrj.crudusers.core.usecases.interf;

import br.com.pedrohbhrj.crudusers.core.domain.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
