package com.foodiefy.mainservice.repository;

import com.foodiefy.mainservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
