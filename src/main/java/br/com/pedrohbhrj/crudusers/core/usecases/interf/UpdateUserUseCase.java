package br.com.pedrohbhrj.crudusers.core.usecases.interf;

import br.com.pedrohbhrj.crudusers.core.domain.User;

public interface UpdateUserUseCase {
    User updateUser(Long id,User user);
}
