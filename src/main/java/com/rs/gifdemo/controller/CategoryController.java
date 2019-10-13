package com.rs.gifdemo.controller;

import com.rs.gifdemo.model.Category;
import com.rs.gifdemo.model.Gif;
import com.rs.gifdemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        // 1. Wyciąganie kategorii
        List<Category> categories = categoryRepository.getAllCategories();
        // 2. Przekazanie kategorii do View
        modelMap.put("categories", categories);
        // 3. Zwracanie widoku
        return "categories";


    }

}
