package com.example.lab112.Controller;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Category;
import com.example.lab112.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public ResponseEntity getCategories(){
        List<Category> categoryList = categoryService.getCategories();
        return ResponseEntity.status(200).body(categoryList);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiException("Category added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body(new ApiException("Category updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body(new ApiException("Category deleted successfully"));

    }
}
