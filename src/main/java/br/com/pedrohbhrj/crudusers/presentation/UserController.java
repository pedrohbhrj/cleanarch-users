package br.com.pedrohbhrj.crudusers.presentation;

import br.com.pedrohbhrj.crudusers.core.domain.User;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.CreateUserUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.DeleteUserByIdUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.FindAllUsersUseCase;
import br.com.pedrohbhrj.crudusers.core.usecases.interf.FindUserByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserUseCase.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(findUserByIdUseCase.findUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(findAllUsersUseCase.findAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        deleteUserByIdUseCase.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserUseCase.createUser(user));
    }

}
