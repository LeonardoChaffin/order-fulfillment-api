package com.projectSB.projectSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSB.projectSB.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
