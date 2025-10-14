package com.bobadilla.spring.portaljob.spring_pure_jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.JobSeekerProfile;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.RecruiterProfile;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.Users;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.repository.JobSeekerProfileRepository;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.repository.RecruiterProfileRepository;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.repository.UsersRepository;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    private UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository){
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository= recruiterProfileRepository;
    }

    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUsers = usersRepository.save(users);
        int userTypeId= users.getuserTypeId().getUserTypeId();
        if(userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
        }
        return savedUsers;
    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }


}
