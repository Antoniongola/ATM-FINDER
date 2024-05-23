package com.ngolajr.cashfinderapifinal.services;

import com.ngolajr.cashfinderapifinal.dto.AtmCreationDto;
import com.ngolajr.cashfinderapifinal.dto.AtmStateUpdate;
import com.ngolajr.cashfinderapifinal.entities.Atm;
import com.ngolajr.cashfinderapifinal.repository.AtmRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.security.Timestamp;

@Service
@RequiredArgsConstructor
public class AtmServices {
    private final AtmRepository repository;

    @CreationTimestamp
    Timestamp time;
    public Atm createAtm(AtmCreationDto dto){
        Atm atm = new Atm();
        atm.setBairro(dto.local());
        atm.setLongitude(dto.longitude());
        atm.setLatitude(dto.latitude());
        atm.setTemDinheiro(dto.dinheiro());
        atm.setTemPapel(dto.papel());
        atm.setTemSistema(dto.sistema());
        repository.save(atm);

        return repository.findAll().getLast();
    }

    public Atm atualizarEstado(AtmStateUpdate update, Long id){
        Atm atm = new Atm();
        if(repository.existsById(id))
            atm = repository.findById(id).get();


        atm.setTemPapel(update.papel());
        atm.setTemDinheiro(update.dinheiro());
        atm.setTemSistema(update.sistema());
        atm.setAtualizadoEm(time);
        repository.save(atm);
        return atm;
    }
}
