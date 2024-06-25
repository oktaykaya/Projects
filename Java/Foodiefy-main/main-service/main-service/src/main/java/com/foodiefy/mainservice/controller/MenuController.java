package com.foodiefy.mainservice.controller;

import com.foodiefy.mainservice.dto.MenuDto;
import com.foodiefy.mainservice.service.MenuService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")

public class MenuController {

    private final MenuService menuService;


    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuDto>> getAllMenus(){
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDto> getMenuById(@PathVariable long id){
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addMenu(@RequestBody MenuDto menuDto){
        return ResponseEntity.ok(menuService.addMenu(menuDto));
    }
    @PutMapping("/updated/{id}")
    public ResponseEntity<String> update(@RequestBody MenuDto menuDto, @PathVariable long id){
        return ResponseEntity.ok(menuService.updateMenu(menuDto, id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(menuService.deleteMenu(id));
    }
}
