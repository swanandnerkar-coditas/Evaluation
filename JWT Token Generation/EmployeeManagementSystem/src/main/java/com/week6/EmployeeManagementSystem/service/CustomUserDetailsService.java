package com.week6.EmployeeManagementSystem.service;

import com.week6.EmployeeManagementSystem.model.User;
import com.week6.EmployeeManagementSystem.model.UserPrincipal;
import com.week6.EmployeeManagementSystem.repository.EmployeeRepository;
import com.week6.EmployeeManagementSystem.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// implemented class of UserDetailsService
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(UserRepo userRepo, EmployeeRepository employeeRepository) {
        this.userRepo = userRepo;
        this.employeeRepository = employeeRepository;
    }

    // not provided default constructor

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // UserDetails is interface so can use implemented class User
        User userDB = userRepo.findByUsername(username);

        if(userDB == null) throw new UsernameNotFoundException("User not found");

//        return new UserPrincipal(userDB.getUsername(), userDB.getPassword(), employeeRepository.findRoleByEmail(username));
        return new UserPrincipal(userDB.getUsername(), userDB.getPassword(), employeeRepository.findByEmail(username).getRole());
    }
}
