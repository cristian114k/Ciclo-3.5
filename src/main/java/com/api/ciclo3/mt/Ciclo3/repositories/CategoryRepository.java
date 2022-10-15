package com.api.ciclo3.mt.Ciclo3.repositories;

import com.api.ciclo3.mt.Ciclo3.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return  (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c) {
        return categoryCrudRepository.save(c);
    }

    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }
}
