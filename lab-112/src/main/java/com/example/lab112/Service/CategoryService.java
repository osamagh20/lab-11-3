package com.example.lab112.Service;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Category;
import com.example.lab112.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id,Category category){
        Category oldCategory = categoryRepository.findCategoriesByCategoryId(id);
        if(oldCategory == null){
            throw new ApiException("id not found");
        }
        oldCategory.setName(category.getName());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id){
        Category delCategory = categoryRepository.findCategoriesByCategoryId(id);
        if(delCategory == null){
            throw new ApiException("id not found");
        }
        categoryRepository.delete(delCategory);
    }
}
