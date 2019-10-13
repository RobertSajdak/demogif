package com.rs.gifdemo.repository;

import com.rs.gifdemo.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0, "funny"),
            new Category(1, "sport"),
            new Category(2, "it")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category getCategoryById(int id) {

        for (Category cat : ALL_CATEGORIES) {
            if (cat.getId() == id) {
                return cat;
            }
        }
        return null;
    }
}
