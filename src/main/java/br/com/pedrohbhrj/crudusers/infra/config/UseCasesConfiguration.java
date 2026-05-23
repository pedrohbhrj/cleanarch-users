package br.com.pedrohbhrj.crudusers.infra.config;


import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.impl.*;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UseCasesConfiguration {

    private final UserGateway userGateway;

    @Bean
    public FindAllUsersUseCase findAllUsersUseCase(){
        return new FindAllUsersUseCaseImpl(userGateway);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(){
        return new FindUserByIdUseCaseImpl(userGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(){
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(){
        return new DeleteUserByIdUseCaseImpl(userGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(){
        return new UpdateUserUseCaseImpl(userGateway);
    }


}
