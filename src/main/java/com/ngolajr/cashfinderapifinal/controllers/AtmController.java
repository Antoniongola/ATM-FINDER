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
    private final AtmServices service;

    @PostMapping("")
    public ResponseEntity<Atm> criarAtm(@RequestBody AtmCreationDto dto){
        if(this.service.createAtm(dto) != null)
            return ResponseEntity.ok(service.lastAddedAtm());

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atm> atualizarAtm(@PathVariable long id, @RequestBody AtmStateUpdate update){
        if(service.atualizarEstado(update, id) != null){
            return ResponseEntity.ok(service.atualizarEstado(update, id));
        }

        return null;
    }

    @GetMapping("")
    public ResponseEntity<List<Atm>> atms(){
        return ResponseEntity.ok(service.atms());
    }

    @GetMapping("/dinheiro")
    public ResponseEntity<Integer> atmsDinheiro(){
        return ResponseEntity.ok(this.service.atmsDinheiro());
    }

    @GetMapping("/papel")
    public ResponseEntity<Integer> atmsPapel(){
        return ResponseEntity.ok(this.service.atmsPapel());
    }

    @GetMapping("/sistema")
    public ResponseEntity<Integer> atmsSistema(){
        return ResponseEntity.ok(this.service.atmsSistema());
    }


}
