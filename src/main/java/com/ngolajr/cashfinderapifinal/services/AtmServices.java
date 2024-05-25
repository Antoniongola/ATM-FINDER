package com.ngolajr.cashfinderapifinal.services;

import com.ngolajr.cashfinderapifinal.dto.AtmCreationDto;
import com.ngolajr.cashfinderapifinal.dto.AtmStateUpdate;
import com.ngolajr.cashfinderapifinal.entities.Atm;
import com.ngolajr.cashfinderapifinal.repository.AtmRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtmServices {
    private final AtmRepository repository;

    public Atm createAtm(AtmCreationDto dto){
        Atm atm = new Atm();
        atm.setNome(dto.nome());
        atm.setBairro(dto.local());
        atm.setLongitude(dto.longitude());
        atm.setLatitude(dto.latitude());
        atm.setTemDinheiro(dto.dinheiro());
        atm.setTemPapel(dto.papel());
        atm.setTemSistema(dto.sistema());
        System.out.println(atm);
        repository.save(atm);
        List<Atm> lista = repository.findAll();

        return lista.get(lista.size()-1);
    }

    public Atm atualizarEstado(AtmStateUpdate update, Long id){
        Atm atm = new Atm();
        if(repository.existsById(id))
            atm = repository.findById(id).get();


        atm.setTemPapel(update.papel());
        atm.setTemDinheiro(update.dinheiro());
        atm.setTemSistema(update.sistema());
        System.out.println(atm);
        repository.save(atm);

        return atm;
    }

    public List<Atm> pesquisarAtmPeloLocal(String local){
        return repository.findAtmsByBairro(local);
    }

    public Atm lastAddedAtm(){
        List<Atm> lista = repository.findAll();
        return lista.get(lista.size()-1);
    }

    public List<Atm> atms(){
        return repository.findAll();
    }

    public int atmsDinheiro(){
        int count=0;
        List<Atm> lista = repository.findAll();
        for(Atm atm : lista)
            if(atm.isTemDinheiro())
                count++;

        return count;
    }

    public int atmsPapel(){
        int count=0;
        List<Atm> lista = repository.findAll();
        for(Atm atm : lista)
            if(atm.isTemPapel())
                count++;

        return count;
    }

    public int atmsSistema(){
        int count=0;
        List<Atm> lista = repository.findAll();
        for(Atm atm : lista)
            if(atm.isTemSistema())
                count++;

        return count;
    }
}
