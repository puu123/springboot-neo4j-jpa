package com.example.demo.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityJpaRepository extends JpaRepository<UserEntity, Long>
{
    //User findByUsername(String username);
}
