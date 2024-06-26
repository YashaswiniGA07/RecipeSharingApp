package com.recipesharing.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByEmail(String emailId);
}