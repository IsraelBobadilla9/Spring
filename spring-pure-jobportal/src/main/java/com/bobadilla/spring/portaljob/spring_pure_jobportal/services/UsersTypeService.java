package com.bobadilla.spring.portaljob.spring_pure_jobportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.UsersTypeE;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository){
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersTypeE> getAll(){
        return usersTypeRepository.findAll();
    }

}
