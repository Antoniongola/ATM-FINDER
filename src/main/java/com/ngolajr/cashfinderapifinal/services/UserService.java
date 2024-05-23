package com.ngolajr.cashfinderapifinal.services;

import com.ngolajr.cashfinderapifinal.dto.LoginRequest;
import com.ngolajr.cashfinderapifinal.entities.User;
import com.ngolajr.cashfinderapifinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User login(LoginRequest login){
        if(repository.existsById(login.numero())){
            return repository.findById(login.numero()).get();
        }

        return null;
    }

    public User criarConta(User user){
        if(repository.existsById(user.getNumero())){
            return null;
        }
        repository.save(user);
        return repository.findById(user.getNumero()).get();
    }

}
