package com.ngolajr.cashfinderapifinal.services;

import com.ngolajr.cashfinderapifinal.dto.LoginRequest;
import com.ngolajr.cashfinderapifinal.entities.User;
import com.ngolajr.cashfinderapifinal.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class UserService {
    private final UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public User login(LoginRequest login){
        if(repository.existsById(login.numero())){
            User user = repository.findById(login.numero()).get();
            if(encoder.matches(login.senha(), user.getSenha()))
                return user;

            return null;
        }

        return null;
    }

    public User criarConta(User user){
        if(repository.existsById(user.getNumero())){
            return null;
        }
        user.setSenha(encoder.encode(user.getSenha()));
        repository.save(user);
        return repository.findById(user.getNumero()).get();
    }

    public User selecionarUser(int numero){
        if(repository.existsById(numero))
            return repository.findById(numero).get();

        return null;
    }

}
