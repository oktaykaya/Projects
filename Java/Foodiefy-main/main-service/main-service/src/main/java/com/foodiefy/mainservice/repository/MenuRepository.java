package com.foodiefy.mainservice.repository;

import com.foodiefy.mainservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu, Long> {
}
