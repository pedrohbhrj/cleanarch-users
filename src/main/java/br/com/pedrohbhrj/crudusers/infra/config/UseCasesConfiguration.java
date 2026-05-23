package br.com.pedrohbhrj.crudusers.infra.config;


import br.com.pedrohbhrj.crudusers.core.gateway.UserGateway;
import br.com.pedrohbhrj.crudusers.core.usecases.impl.CreateUserUseCaseImpl;
import br.com.pedrohbhrj.crudusers.core.usecases.impl.DeleteUserByIdUseCaseImpl;
import br.com.pedrohbhrj.crudusers.core.usecases.impl.FindAllUsersUseCaseImpl;
import br.com.pedrohbhrj.crudusers.core.usecases.impl.FindUserByIdUseCaseImpl;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.CreateUserUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.DeleteUserByIdUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.FindAllUsersUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.FindUserByIdUseCase;
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


}
