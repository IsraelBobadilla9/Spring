package com.bobadilla.spring.portaljob.spring_pure_jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.Users;

// uso de spring data jpa al extender jparepository
public interface UsersRepository extends JpaRepository<Users,Integer>{

    Optional<Users> findByEmail(String email);
    
}
