package com.foodiefy.mainservice.controller;

import com.foodiefy.mainservice.dto.CategoryDto;
import com.foodiefy.mainservice.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
    * @GetMapping -> get mapping
    * ResponseEntity -> response entity
    * This method returns all the categories
     */
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    /*
    * @PathVariable -> path variable is mapped to the variable
    * @GetMapping -> get mapping
    * this method returns the category by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }



    /*
    * @RequestBody -> request body is mapped to the object
    * @PathVariable -> path variable is mapped to the variable
    * this method adds the category
     */
    @PostMapping("/create")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.addCategory(categoryDto));
    }
    // DENEME
    // @PostMapping("/create")
    // public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
    //     // Örnek bir çıktı oluştur
    //     CategoryDto responseDto = CategoryDto.builder()
    //             .name(categoryDto.getName())
    //             .description(categoryDto.getDescription())
    //             .recipes(categoryDto.getRecipes())
    //             .message("Başarıyla eklendi: " + categoryDto.getName())
    //             .build();
    
    //     // Oluşturulan çıktıyı response entity içinde frontend'e gönder
    //     return ResponseEntity.ok(responseDto);
    // }

    /*
    * @RequestBody -> request body is mapped to the object
    * @PathVariable -> path variable is mapped to the variable
    * this method updates the category
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody CategoryDto categoryDto, @PathVariable long id){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, id));
    }

    /*
    * @PathVariable -> path variable is mapped to the variable
    * @DeleteMapping -> delete mapping
    * this method deletes the category
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }


}
