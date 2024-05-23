package com.ngolajr.cashfinderapifinal.repository;

import com.ngolajr.cashfinderapifinal.entities.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {
}
