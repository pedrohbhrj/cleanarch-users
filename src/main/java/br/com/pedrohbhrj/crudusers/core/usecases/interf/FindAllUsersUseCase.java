package br.com.pedrohbhrj.crudusers.core.usecases.interf;

import br.com.pedrohbhrj.crudusers.core.domain.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> findAllUsers();
}
