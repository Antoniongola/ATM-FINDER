package com.ngolajr.cashfinderapifinal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    private String nome;
    @Id
    private int numero;
    private String senha;
}
