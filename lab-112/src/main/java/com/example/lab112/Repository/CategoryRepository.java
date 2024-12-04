package com.example.lab112.Repository;

import com.example.lab112.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoriesByCategoryId(Integer id);

}
