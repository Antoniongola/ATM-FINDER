package com.ngolajr.cashfinderapifinal.controllers;

import com.ngolajr.cashfinderapifinal.dto.AtmCreationDto;
import com.ngolajr.cashfinderapifinal.dto.AtmStateUpdate;
import com.ngolajr.cashfinderapifinal.entities.Atm;
import com.ngolajr.cashfinderapifinal.services.AtmServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("**")
@RequestMapping(path = "/api/atm", produces = "application/json")
@RequiredArgsConstructor
public class AtmController {
    private AtmServices service;

    @PostMapping("")
    public ResponseEntity<Atm> criarAtm(@RequestBody AtmCreationDto dto){
        if(service.createAtm(dto) != null)
            return ResponseEntity.ok(service.createAtm(dto));

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atm> atualizarAtm(@PathVariable long id, AtmStateUpdate update){
        if(service.atualizarEstado(update, id) != null){
            return ResponseEntity.ok(service.atualizarEstado(update, id));
        }

        return null;
    }

    @GetMapping("")
    public ResponseEntity<List<Atm>> atms(){
        return ResponseEntity.ok(service.atms());
    }
}
