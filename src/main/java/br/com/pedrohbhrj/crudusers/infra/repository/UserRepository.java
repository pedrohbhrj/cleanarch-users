package br.com.pedrohbhrj.crudusers.infra.repository;

import br.com.pedrohbhrj.crudusers.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
