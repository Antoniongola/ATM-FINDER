package com.ngolajr.cashfinderapifinal.repository;

import com.ngolajr.cashfinderapifinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
