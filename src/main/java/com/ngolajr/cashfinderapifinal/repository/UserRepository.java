package com.ngolajr.cashfinderapifinal.repository;

import com.ngolajr.cashfinderapifinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
